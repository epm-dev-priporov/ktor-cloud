package dev.priporov.eureka.client

import com.netflix.appinfo.ApplicationInfoManager
import com.netflix.appinfo.HealthCheckHandler
import com.netflix.appinfo.InstanceInfo
import com.netflix.appinfo.providers.EurekaConfigBasedInstanceInfoProvider
import com.netflix.discovery.DiscoveryClient
import dev.priporov.eureka.client.config.EurekaConfig
import dev.priporov.eureka.client.config.instance.EurekaInstanceConfigBuilder
import io.ktor.application.*
import io.ktor.util.AttributeKey


class EurekaClientFeature private constructor(
    private val monitor: ApplicationEvents,
    private var eurekaConfig: EurekaConfig,
    private val pipeline: Application
) {
    private val eurekaDiscoveryClientKey = AttributeKey<DiscoveryClient>("EurekaDiscoveryClient")

    init {
        monitor.subscribe(ApplicationStarted) {
            val instanceConfig = EurekaInstanceConfigBuilder.build(eurekaConfig, pipeline)

            val instanceInfo = EurekaConfigBasedInstanceInfoProvider(instanceConfig).get()

            val discoveryClient = DiscoveryClient(
                ApplicationInfoManager(instanceConfig, instanceInfo),
                eurekaConfig
            )

            pipeline.attributes.put(eurekaDiscoveryClientKey, discoveryClient)
            monitor.raise(EurekaClientConnected, discoveryClient)

            discoveryClient.registerHealthCheck(HealthCheckHandler {
                InstanceInfo.InstanceStatus.UP
            })

            // since ktor does not support ApplicationStopped and ApplicationStopping events, this is used to shutdown discovery client
            Runtime.getRuntime().addShutdownHook(Thread {
                monitor.raise(ApplicationStopped, pipeline)
            })
        }

        monitor.subscribe(ApplicationStopped) {
            val discoveryClient: DiscoveryClient = pipeline.attributes[eurekaDiscoveryClientKey]
            discoveryClient.applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.DOWN)
            monitor.raise(EurekaClientClosed, discoveryClient)
            discoveryClient.shutdown()
        }

    }

    companion object Feature : ApplicationFeature<Application, EurekaConfig, EurekaClientFeature> {
        override val key: AttributeKey<EurekaClientFeature> = AttributeKey("EurekaClientFeature")

        override fun install(pipeline: Application, configure: EurekaConfig.() -> Unit): EurekaClientFeature {
            return EurekaClientFeature(
                pipeline.environment.monitor,
                EurekaConfig().apply(configure),
                pipeline
            )
        }
    }

}
