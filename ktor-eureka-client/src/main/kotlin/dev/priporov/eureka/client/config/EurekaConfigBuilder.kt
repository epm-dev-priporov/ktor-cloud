package dev.priporov.eureka.client.config

import io.ktor.application.Application
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.server.engine.ApplicationEngineEnvironment
import io.ktor.server.engine.EngineConnectorConfig
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface

object EurekaConfigBuilder {

    private const val DEFAULT_NON_SECURE_PORT = 80;

    fun build(eurekaConfig: EurekaConfig, pipeline: Application): EurekaConfig {
        val connector = (pipeline.environment as ApplicationEngineEnvironment).connectors.first()

        initIpAddress(eurekaConfig)
        initPort(eurekaConfig, connector)
        initHostName(eurekaConfig)
        initVirtualHostName(eurekaConfig)
        initSecureVirtualHostName(eurekaConfig)
        initInstanceId(eurekaConfig, connector)
        initStatusPageUrl(eurekaConfig)

        return eurekaConfig
    }

    private fun initStatusPageUrl(eurekaConfig: EurekaConfig) {
        if (eurekaConfig.statusPageUrl == null) {
            val ipAddress = eurekaConfig.ipAddress ?: throw IllegalArgumentException("ipAddress can not be null")

            val healthCheckUrlPath = eurekaConfig.healthCheckUrlPath ?: ""
            val healthCheck = if (healthCheckUrlPath.startsWith("/")) {
                healthCheckUrlPath.removePrefix("/")
            } else {
                healthCheckUrlPath
            }

            val securePortEnabled = eurekaConfig.securePortEnabled
            var port = if (securePortEnabled) eurekaConfig.nonSecurePort else eurekaConfig.securePort
            var protocol = if (securePortEnabled) URLProtocol.HTTP else URLProtocol.HTTPS

            if (securePortEnabled) {
                protocol = URLProtocol.HTTPS
                port = eurekaConfig.securePort
            }

            val statusPageUrl = URLBuilder(
                protocol = protocol,
                host = ipAddress,
                port = port
            )
                .path(healthCheck)
                .buildString()

            eurekaConfig.setStatusPageUrl(statusPageUrl)
        }
    }

    private fun initInstanceId(
        eurekaConfig: EurekaConfig,
        connector: EngineConnectorConfig
    ) {
        if (eurekaConfig.instanceId == null) {
            eurekaConfig.setInstanceId(
                "${eurekaConfig.ipAddress}:${eurekaConfig.appname}:${connector.port}"
            )
        }
    }

    private fun initSecureVirtualHostName(eurekaConfig: EurekaConfig) {
        if (eurekaConfig.secureVirtualHostName == null) {
            eurekaConfig.secureVirtualHostName = eurekaConfig.appname
        }
    }

    private fun initVirtualHostName(eurekaConfig: EurekaConfig) {
        if (eurekaConfig.virtualHostName == null) {
            eurekaConfig.virtualHostName = eurekaConfig.appname
        }
    }

    private fun initHostName(eurekaConfig: EurekaConfig) {
        if (eurekaConfig.getHostName(false) == InetAddress.getLocalHost().hostName) {
            eurekaConfig.setHostName(
                eurekaConfig.ipAddress
            )
        }
    }

    private fun initPort(
        eurekaConfig: EurekaConfig,
        connector: EngineConnectorConfig
    ) {
        if (eurekaConfig.nonSecurePort == DEFAULT_NON_SECURE_PORT) {
            eurekaConfig.nonSecurePort = connector.port
        }
    }

    private fun initIpAddress(eurekaConfig: EurekaConfig) {
        if (eurekaConfig.ipAddress == InetAddress.getLocalHost().hostAddress) {
            eurekaConfig.setIpAddress(
                findFirstNonLoopbackAddress().hostAddress
            )
        }
    }

    private fun findFirstNonLoopbackAddress(): InetAddress {
        val inetAddress = NetworkInterface.getNetworkInterfaces()
            .asSequence()
            .maxWith(Comparator { o1, o2 -> if (o1.isUp) o1.index.compareTo(o2.index) else -1 })
            ?.inetAddresses
            ?.asSequence()
            ?.firstOrNull {
                (it is Inet4Address) && (!it.isLoopbackAddress) && (isPreferredAddress(
                    it
                ))
            }

        return inetAddress ?: InetAddress.getLocalHost()
    }

    private fun isPreferredAddress(inetAddress: InetAddress): Boolean {
        // todo implement the method
        return true
    }

}
