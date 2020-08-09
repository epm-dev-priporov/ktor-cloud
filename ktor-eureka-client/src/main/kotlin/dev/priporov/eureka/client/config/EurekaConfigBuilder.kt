package dev.priporov.eureka.client.config

import io.ktor.application.Application
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.server.engine.ApplicationEngineEnvironment
import java.lang.IllegalArgumentException
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface

object EurekaConfigBuilder {

    private const val DEFAULT_NON_SECURE_PORT = 80;

    fun build(eurekaConfig: EurekaConfig, pipeline: Application): EurekaConfig {
        val connector = (pipeline.environment as ApplicationEngineEnvironment).connectors.first()

        if (eurekaConfig.ipAddress == InetAddress.getLocalHost().hostAddress) {
            eurekaConfig.setIpAddress(
                findFirstNonLoopbackAddress().hostAddress
            )
        }

        if (eurekaConfig.nonSecurePort == DEFAULT_NON_SECURE_PORT) {
            eurekaConfig.nonSecurePort = connector.port
        }

        if (eurekaConfig.getHostName(false) == InetAddress.getLocalHost().hostName) {
            eurekaConfig.setHostName(
                eurekaConfig.ipAddress
            )
        }

        if (eurekaConfig.virtualHostName == null) {
            eurekaConfig.virtualHostName = eurekaConfig.appname
        }
        if (eurekaConfig.secureVirtualHostName == null) {
            eurekaConfig.secureVirtualHostName = eurekaConfig.appname
        }

        if (eurekaConfig.instanceId == null) {
            eurekaConfig.setInstanceId(
                "${eurekaConfig.ipAddress}:${eurekaConfig.appname}:${connector.port}"
            )
        }

        if(eurekaConfig.statusPageUrl == null){
            val ipAddress = eurekaConfig.ipAddress?: throw IllegalArgumentException("ipAddress can not be null")

            val healthCheckUrlPath = eurekaConfig.healthCheckUrlPath?:""
            val healthCheck =  if(healthCheckUrlPath.startsWith("/")) {
                healthCheckUrlPath.removePrefix("/")
            } else {
                healthCheckUrlPath
            }

            var port = eurekaConfig.nonSecurePort
            var protocol = URLProtocol.HTTP

            if (eurekaConfig.securePortEnabled) {
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

        return eurekaConfig
    }


    private fun findFirstNonLoopbackAddress(): InetAddress {
        val inetAddress = NetworkInterface.getNetworkInterfaces()
            .asSequence()
            .maxWith(Comparator { o1, o2 -> if (o1.isUp) o1.index.compareTo(o2.index) else -1 })
            ?.inetAddresses
            ?.asSequence()
            ?.firstOrNull { (it is Inet4Address) && (!it.isLoopbackAddress) && (isPreferredAddress(
                it
            )) }

        return inetAddress ?: InetAddress.getLocalHost()
    }

    private fun isPreferredAddress(inetAddress: InetAddress): Boolean {
        return true
    }

}
