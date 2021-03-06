package dev.priporov.eureka.client.config.client

import com.netflix.discovery.DefaultEurekaClientConfig.DEFAULT_ZONE
import com.netflix.discovery.EurekaClientConfig
import com.netflix.discovery.shared.transport.EurekaTransportConfig

private const val DEFAULT_REGION = "us-east-1"

interface KtorEurekaClientConfig: EurekaClientConfig {
    fun setEurekaServerTotalConnectionsPerHost(value: Int)
    fun enableUnregisterOnShutdown(value: Boolean)
    fun setHeartbeatExecutorThreadPoolSize(value: Int)
    fun enableGZipContent(value: Boolean)
    fun setRegistryForRemoteRegions(value: String?)
    fun setDollarReplacement(value: String)
    fun setRegistryFetchIntervalSeconds(value: Int)
    fun setEurekaServerReadTimeoutSeconds(value: Int)
    fun setClientDataAccept(value: String)
    fun setEscapeCharReplacement(value: String)
    fun setAvailabilityZones(value: Array<String>, region: String? = DEFAULT_REGION)
    fun setAvailabilityZones(value: Collection<String>, region: String? = DEFAULT_REGION)
    fun setHeartbeatExecutorExponentialBackOffBound(value: Int)
    fun setProxyHost(value: String)
    fun setOnDemandUpdateStatusChange(value: Boolean)
    fun setTransportConfig(value: EurekaTransportConfig)
    fun setProxyUserName(value: String)
    fun setBackupRegistryImpl(value: String)
    fun setInitialInstanceInfoReplicationIntervalSeconds(value: Int)
    fun setDecoderName(value: String)
    fun setPreferSameZoneEureka(value: Boolean)
    fun setEurekaServerURLContext(value: String)
    fun setRegistryRefreshSingleVipAddress(value: String?)
    fun setRegion(value: String)
    fun setEurekaServerDNSName(value: String)
    fun setEncoderName(value: String)
    fun setProxyPassword(value: String)
    fun setEurekaServerConnectTimeoutSeconds(value: Int)
    fun setEurekaServerPort(value: String)
    fun setFilterOnlyUpInstances(value: Boolean)
    fun setEurekaConnectionIdleTimeoutSeconds(value: Int)
    fun setCacheRefreshExecutorThreadPoolSize(value: Int)
    fun setCacheRefreshExecutorExponentialBackOffBound(value: Int)
    fun setInstanceInfoReplicationIntervalSeconds(value: Int)
    fun setEurekaServerTotalConnections(value: Int)
    fun enableAllowRedirects(value: Boolean)
    fun enableRegisterWithEureka(value: Boolean)
    fun setEurekaServiceUrlPollIntervalSeconds(value: Int)
    fun setProxyPort(value: String)
    fun setExperimental(name: String?, value: String)
    fun setEurekaServerServiceUrls(value: List<String>, myZone: String = DEFAULT_ZONE)
    fun enableLogDeltaDiff(value: Boolean)
    fun enableDisableDelta(value: Boolean)
    fun enableFetchRegistry(value: Boolean)
    fun enableEnforceRegistrationAtInit(value: Boolean)
    fun enableUseDnsForFetchingServiceUrls(value: Boolean)

}
