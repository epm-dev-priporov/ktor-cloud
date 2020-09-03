package dev.priporov.eureka.client.config.client

import com.netflix.discovery.DefaultEurekaClientConfig
import com.netflix.discovery.shared.transport.EurekaTransportConfig
import dev.priporov.eureka.client.config.client.EurekaPropertyKey.*


class KtorClientConfig : DefaultEurekaClientConfig(), KtorEurekaClientConfig {
    private val map = HashMap<EurekaPropertyKey, Any?>()

    private var heartbeatExecutorThreadPoolSize: Int = super.getHeartbeatExecutorThreadPoolSize()
    override fun getHeartbeatExecutorThreadPoolSize() = heartbeatExecutorThreadPoolSize
    override fun setHeartbeatExecutorThreadPoolSize(value: Int) { heartbeatExecutorThreadPoolSize = value }

    private var eurekaServerTotalConnectionsPerHost = super.getEurekaServerTotalConnectionsPerHost()
    override fun setEurekaServerTotalConnectionsPerHost(value: Int) { eurekaServerTotalConnectionsPerHost = value }
    override fun getEurekaServerTotalConnectionsPerHost(): Int = eurekaServerTotalConnectionsPerHost

    private var shouldUnregisterOnShutdown = super<DefaultEurekaClientConfig>.shouldUnregisterOnShutdown()
    override fun enableUnregisterOnShutdown(value: Boolean) { shouldUnregisterOnShutdown = value }
    override fun shouldUnregisterOnShutdown(): Boolean = shouldUnregisterOnShutdown

    private var shouldGZipContent = super.shouldGZipContent()
    override fun enableGZipContent(value: Boolean) { shouldGZipContent = value }
    override fun shouldGZipContent(): Boolean = shouldGZipContent

    private var registryForRemoteRegions = super.fetchRegistryForRemoteRegions()
    override fun setRegistryForRemoteRegions(value: String?) { registryForRemoteRegions = value }
    override fun fetchRegistryForRemoteRegions(): String? = registryForRemoteRegions

    private var dollarReplacement = super.getDollarReplacement()
    override fun setDollarReplacement(value: String) { dollarReplacement = value }
    override fun getDollarReplacement(): String? = dollarReplacement

    private var registryFetchIntervalSeconds = super.getRegistryFetchIntervalSeconds()
    override fun setRegistryFetchIntervalSeconds(value: Int) { registryFetchIntervalSeconds = value }
    override fun getRegistryFetchIntervalSeconds(): Int = registryFetchIntervalSeconds

    private var eurekaServerReadTimeoutSeconds= super.getEurekaServerReadTimeoutSeconds()
    override fun setEurekaServerReadTimeoutSeconds(value: Int) { eurekaServerReadTimeoutSeconds = value }
    override fun getEurekaServerReadTimeoutSeconds(): Int = eurekaServerReadTimeoutSeconds

    private var clientDataAccept = super.getClientDataAccept()
    override fun setClientDataAccept(value: String) { clientDataAccept = value }
    override fun getClientDataAccept(): String? = clientDataAccept

    private var escapeCharReplacement = super.getEscapeCharReplacement()
    override fun setEscapeCharReplacement(value: String) { escapeCharReplacement = value }
    override fun getEscapeCharReplacement(): String? = escapeCharReplacement

    private var heartbeatExecutorExponentialBackOffBound = super.getHeartbeatExecutorExponentialBackOffBound()
    override fun setHeartbeatExecutorExponentialBackOffBound(value: Int) { heartbeatExecutorExponentialBackOffBound = value }
    override fun getHeartbeatExecutorExponentialBackOffBound(): Int = heartbeatExecutorExponentialBackOffBound

    private var proxyHost = super.getProxyHost()
    override fun setProxyHost(value: String) { proxyHost = value }
    override fun getProxyHost(): String? = proxyHost

    private var demandUpdateStatusChange = super.shouldOnDemandUpdateStatusChange()
    override fun setOnDemandUpdateStatusChange(value: Boolean) { demandUpdateStatusChange = value }
    override fun shouldOnDemandUpdateStatusChange(): Boolean = demandUpdateStatusChange

    private var transportConfig = super.getTransportConfig()
    override fun setTransportConfig(value: EurekaTransportConfig) { transportConfig = value }
    override fun getTransportConfig(): EurekaTransportConfig? = transportConfig

    private var proxyUserName = super.getProxyUserName()
    override fun setProxyUserName(value: String) { proxyUserName = value }
    override fun getProxyUserName(): String? = proxyUserName

    private var backupRegistryImpl = super.getBackupRegistryImpl()
    override fun setBackupRegistryImpl(value: String) { backupRegistryImpl = value }
    override fun getBackupRegistryImpl(): String? = backupRegistryImpl

    private var  initialInstanceInfoReplicationIntervalSeconds = super.getInitialInstanceInfoReplicationIntervalSeconds()
    override fun setInitialInstanceInfoReplicationIntervalSeconds(value: Int) { initialInstanceInfoReplicationIntervalSeconds = value }
    override fun getInitialInstanceInfoReplicationIntervalSeconds(): Int =initialInstanceInfoReplicationIntervalSeconds

    private var decoderName = super.getDecoderName()
    override fun setDecoderName(value: String) { decoderName = value }
    override fun getDecoderName(): String? = decoderName

    private var preferSameZoneEureka = super.shouldPreferSameZoneEureka()
    override fun setPreferSameZoneEureka(value: Boolean) { preferSameZoneEureka = value }
    override fun shouldPreferSameZoneEureka(): Boolean = preferSameZoneEureka

    private var fetchRegistry = super.shouldFetchRegistry()
    override fun enableFetchRegistry(value: Boolean) { fetchRegistry = value }
    override fun shouldFetchRegistry(): Boolean = fetchRegistry

    private var enforceRegistrationAtInit = super<DefaultEurekaClientConfig>.shouldEnforceRegistrationAtInit()
    override fun enableEnforceRegistrationAtInit(value: Boolean) { enforceRegistrationAtInit = value }
    override fun shouldEnforceRegistrationAtInit(): Boolean = enforceRegistrationAtInit

    private var eurekaServerUrlcontext = super.getEurekaServerURLContext()
    override fun setEurekaServerURLContext(value: String) { eurekaServerUrlcontext = value }
    override fun getEurekaServerURLContext(): String? = eurekaServerUrlcontext

    private var registryRefreshSingleVipAddress = super.getRegistryRefreshSingleVipAddress()
    override fun setRegistryRefreshSingleVipAddress(value: String?) { registryRefreshSingleVipAddress = value }
    override fun getRegistryRefreshSingleVipAddress(): String? = registryRefreshSingleVipAddress

    private var region = super.getRegion()
    override fun setRegion(value: String) { region = value }
    override fun getRegion(): String? = region

    private var eurekaServerDnsname = super.getEurekaServerDNSName()
    override fun setEurekaServerDNSName(value: String) { eurekaServerDnsname = value }
    override fun getEurekaServerDNSName(): String? = eurekaServerDnsname

    private var useDnsForFetchingServiceUrls =  super.shouldUseDnsForFetchingServiceUrls()
    override fun enableUseDnsForFetchingServiceUrls(value: Boolean) { useDnsForFetchingServiceUrls = value }
    override fun shouldUseDnsForFetchingServiceUrls(): Boolean = useDnsForFetchingServiceUrls

    private var encoderName = super.getEncoderName()
    override fun setEncoderName(value: String) { encoderName = value }
    override fun getEncoderName(): String? = encoderName

    private var proxyPassword = super.getProxyPassword()
    override fun setProxyPassword(value: String) { proxyPassword = value }
    override fun getProxyPassword(): String? = proxyPassword

    private var eurekaServerConnectTimeoutSeconds = super.getEurekaServerConnectTimeoutSeconds()
    override fun setEurekaServerConnectTimeoutSeconds(value: Int) { eurekaServerConnectTimeoutSeconds = value }
    override fun getEurekaServerConnectTimeoutSeconds(): Int = eurekaServerConnectTimeoutSeconds

    private var eurekaServerPort = super.getEurekaServerPort()
    override fun setEurekaServerPort(value: String) { eurekaServerPort = value }
    override fun getEurekaServerPort(): String? =eurekaServerPort

    private var filterOnlyUpInstances = super.shouldFilterOnlyUpInstances()
    override fun setFilterOnlyUpInstances(value: Boolean) { filterOnlyUpInstances = value }
    override fun shouldFilterOnlyUpInstances(): Boolean =filterOnlyUpInstances

    private var  eurekaConnectionIdleTimeoutSeconds = super.getEurekaConnectionIdleTimeoutSeconds()
    override fun setEurekaConnectionIdleTimeoutSeconds(value: Int) { eurekaConnectionIdleTimeoutSeconds = value }
    override fun getEurekaConnectionIdleTimeoutSeconds(): Int = eurekaConnectionIdleTimeoutSeconds

    private var  cacheRefreshExecutorThreadPoolSize = super.getCacheRefreshExecutorThreadPoolSize()
    override fun setCacheRefreshExecutorThreadPoolSize(value: Int) { cacheRefreshExecutorThreadPoolSize = value }
    override fun getCacheRefreshExecutorThreadPoolSize(): Int = cacheRefreshExecutorThreadPoolSize

    private var  cacheRefreshExecutorExponentialBackOffBound  = super.getCacheRefreshExecutorExponentialBackOffBound()
    override fun setCacheRefreshExecutorExponentialBackOffBound(value: Int) { cacheRefreshExecutorExponentialBackOffBound = value }
    override fun getCacheRefreshExecutorExponentialBackOffBound(): Int = cacheRefreshExecutorExponentialBackOffBound

    private var  instanceInfoReplicationIntervalSeconds  = super.getInstanceInfoReplicationIntervalSeconds()
    override fun setInstanceInfoReplicationIntervalSeconds(value: Int) { instanceInfoReplicationIntervalSeconds = value }
    override fun getInstanceInfoReplicationIntervalSeconds(): Int = instanceInfoReplicationIntervalSeconds

    private var eurekaServerTotalConnections = super.getEurekaServerTotalConnections()
    override fun setEurekaServerTotalConnections(value: Int) { eurekaServerTotalConnections = value }
    override fun getEurekaServerTotalConnections(): Int = eurekaServerTotalConnections

    private var allowRedirects = super.allowRedirects()
    override fun enableAllowRedirects(value: Boolean) { allowRedirects = value }
    override fun allowRedirects(): Boolean = allowRedirects

    private var registerWithEureka = super.shouldRegisterWithEureka()
    override fun enableRegisterWithEureka(value: Boolean) { registerWithEureka = value }
    override fun shouldRegisterWithEureka(): Boolean = registerWithEureka

    private var eurekaServiceUrlPollIntervalSeconds = super.getEurekaServiceUrlPollIntervalSeconds()
    override fun setEurekaServiceUrlPollIntervalSeconds(value: Int) { eurekaServiceUrlPollIntervalSeconds = value }
    override fun getEurekaServiceUrlPollIntervalSeconds(): Int = eurekaServiceUrlPollIntervalSeconds

    private var proxyPort = super.getProxyPort()
    override fun setProxyPort(value: String) { proxyPort = value }
    override fun getProxyPort(): String? = proxyPort

    private var logDeltaDiff = super.shouldLogDeltaDiff()
    override fun enableLogDeltaDiff(value: Boolean) { logDeltaDiff = value }
    override fun shouldLogDeltaDiff(): Boolean = logDeltaDiff

    private var disableDelta = super.shouldDisableDelta()
    override fun enableDisableDelta(value: Boolean) { disableDelta = value }
    override fun shouldDisableDelta(): Boolean = disableDelta

    override fun setExperimental(name: String?, value: String) {
        map[EXPERIMENTAL.withKey(name)] = value
    }
    override fun getExperimental(name: String?): String? {
        return map.getOrDefault(EXPERIMENTAL.withKey(name), super.getExperimental(name)) as String?
    }

    override fun setEurekaServerServiceUrls(value: List<String>, myZone: String) {
        map[EUREKA_SERVER_SERVICE_URLS.withKey(myZone)] = value
    }
    @Suppress("UNCHECKED_CAST")
    override fun getEurekaServerServiceUrls(myZone: String?): List<String> {
        return (map.getOrDefault(
            EUREKA_SERVER_SERVICE_URLS.withKey(myZone),
            super.getEurekaServerServiceUrls(myZone)
        ) ?: emptyList<String>()) as MutableList<String>
    }

    override fun setAvailabilityZones(value: Array<String>, region: String?) {
        map[AVAILABILITY_ZONES.withKey(region)] = value
    }
    override fun setAvailabilityZones(value: Collection<String>, region: String?) {
        map[AVAILABILITY_ZONES.withKey(region)] = value.toTypedArray()
    }
    @Suppress("UNCHECKED_CAST")
    override fun getAvailabilityZones(region: String?): Array<String> {
        return map.getOrDefault(
            AVAILABILITY_ZONES.withKey(region),
            super.getAvailabilityZones(region)
        ) as Array<String>
    }

}

private enum class EurekaPropertyKey {
    AVAILABILITY_ZONES,
    EXPERIMENTAL,
    EUREKA_SERVER_SERVICE_URLS;

    private var key: String? = null

    fun withKey(key: String?) = this.apply { this.key = key }
}
