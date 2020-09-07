package dev.priporov.eureka.client.config.instance

import dev.priporov.eureka.client.config.EurekaConfig
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.engine.*
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface

object EurekaInstanceConfigBuilder {

    private const val DEFAULT_NON_SECURE_PORT = 80;

    fun build(ktorInstanceConfig: EurekaConfig, pipeline: Application): EurekaConfig {
        val connector = (pipeline.environment as ApplicationEngineEnvironment).connectors.first()

        initIpAddress(ktorInstanceConfig);
        initPort(ktorInstanceConfig, connector);
        initHostName(ktorInstanceConfig);
        initVirtualHostName(ktorInstanceConfig);
        initSecureVirtualHostName(ktorInstanceConfig);
        initInstanceId(ktorInstanceConfig, connector);
        initStatusPageUrl(ktorInstanceConfig)
        initHealthCheckPageUrl(ktorInstanceConfig)
        initHomePageUrl(ktorInstanceConfig)

        return ktorInstanceConfig
    }

    // todo use /info path
    private fun initStatusPageUrl(ktorInstanceConfig: EurekaConfig) {
        if (ktorInstanceConfig.statusPageUrl == null) {

            val statusPageUrlPath = preparePath(ktorInstanceConfig.statusPageUrlPath)

            ktorInstanceConfig.statusPageUrl = toUrlBuilder(ktorInstanceConfig)
                .path(statusPageUrlPath)
                .buildString()
        }
    }

    private fun initHealthCheckPageUrl(ktorInstanceConfig: EurekaConfig) {
        if (ktorInstanceConfig.healthCheckUrl == null) {
            val healthCheckUrlPath = preparePath(ktorInstanceConfig.healthCheckUrlPath)

            ktorInstanceConfig.healthCheckUrl = toUrlBuilder(ktorInstanceConfig)
                .path(healthCheckUrlPath)
                .buildString()
        }
    }

    private fun initHomePageUrl(ktorInstanceConfig: EurekaConfig) {
        if (ktorInstanceConfig.homePageUrl == null) {
            val homePageUrlPath = preparePath(ktorInstanceConfig.homePageUrlPath)

            ktorInstanceConfig.healthCheckUrl = toUrlBuilder(ktorInstanceConfig)
                .path(homePageUrlPath)
                .buildString()
        }
    }

    private fun preparePath(path:String?):String  {
        if(path == null){
            return ""
        }
        if (path.startsWith("/")) {
            return path.removePrefix("/")
        }
        return path
    }

    private fun toUrlBuilder(ktorInstanceConfig: EurekaConfig): URLBuilder {
        var ipAddress = ktorInstanceConfig.ipAddress
        var port = ktorInstanceConfig.nonSecurePort
        var protocol = URLProtocol.HTTP
        if(ktorInstanceConfig.secureOnly()){
            port = ktorInstanceConfig.securePort
            protocol = URLProtocol.HTTPS
        }

        return URLBuilder(
            protocol = protocol,
            host = ipAddress,
            port = port
        )
    }

    private fun initInstanceId(
        ktorInstanceConfig: EurekaConfig,
        connector: EngineConnectorConfig
    ) {
        if (ktorInstanceConfig.instanceId == null) {
            ktorInstanceConfig.setInstanceId(
                "${ktorInstanceConfig.ipAddress}:${ktorInstanceConfig.appname}:${connector.port}"
            )
        }
    }

    private fun initSecureVirtualHostName(ktorInstanceConfig: EurekaConfig) {
        if (ktorInstanceConfig.secureVirtualHostName == null) {
            ktorInstanceConfig.secureVirtualHostName = ktorInstanceConfig.appname
        }
    }

    private fun initVirtualHostName(ktorInstanceConfig: EurekaConfig) {
        if (ktorInstanceConfig.virtualHostName == null) {
            ktorInstanceConfig.virtualHostName = ktorInstanceConfig.appname
        }
    }

    private fun initHostName(ktorInstanceConfig: EurekaConfig) {
        if (ktorInstanceConfig.getHostName(false) == InetAddress.getLocalHost().hostName) {
            ktorInstanceConfig.setHostName(
                ktorInstanceConfig.ipAddress
            )
        }
    }

    private fun initPort(
        ktorInstanceConfig: EurekaConfig,
        connector: EngineConnectorConfig
    ) {
        if (ktorInstanceConfig.nonSecurePort == DEFAULT_NON_SECURE_PORT) {
            ktorInstanceConfig.nonSecurePort = connector.port
        }
    }

    private fun initIpAddress(ktorInstanceConfig: EurekaConfig) {
        if (ktorInstanceConfig.ipAddress == InetAddress.getLocalHost().hostAddress) {
            ktorInstanceConfig.ipAddress = findFirstNonLoopbackAddress().hostAddress
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

    private fun EurekaConfig.secureOnly() = securePortEnabled && !isNonSecurePortEnabled

}
