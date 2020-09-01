package dev.priporov.eureka.client.config.client

import com.netflix.discovery.DefaultEurekaClientConfig
import com.netflix.discovery.shared.transport.EurekaTransportConfig
import dev.priporov.eureka.client.config.client.EurekaPropertyKey.*


class KtorClientConfig : DefaultEurekaClientConfig(), KtorEurekaClientConfig {
    private val map = HashMap<EurekaPropertyKey, Any?>()

    override fun setHeartbeatExecutorThreadPoolSize(value: Int) {
        map[GET_HEARTBEAT_EXECUTOR_THREAD_POOL_SIZE] = value
    }

    override fun getHeartbeatExecutorThreadPoolSize(): Int {
        return map.getOrDefault(
            GET_HEARTBEAT_EXECUTOR_THREAD_POOL_SIZE,
            super.getHeartbeatExecutorThreadPoolSize()
        ) as Int
    }

    override fun setEurekaServerTotalConnectionsPerHost(value: Int) {
        map[GET_EUREKA_SERVER_TOTAL_CONNECTIONS_PER_HOST] = value
    }

    override fun getEurekaServerTotalConnectionsPerHost(): Int {
        return map.getOrDefault(
            GET_EUREKA_SERVER_TOTAL_CONNECTIONS_PER_HOST,
            super.getEurekaServerTotalConnectionsPerHost()
        ) as Int
    }

    override fun enableUnregisterOnShutdown(value: Boolean) {
        map[SHOULD_UNREGISTER_ON_SHUTDOWN] = value
    }

    override fun shouldUnregisterOnShutdown(): Boolean {
        return map.getOrDefault(
            SHOULD_UNREGISTER_ON_SHUTDOWN,
            super<DefaultEurekaClientConfig>.shouldUnregisterOnShutdown()
        ) as Boolean
    }

    override fun enableGZipContent(value: Boolean) {
        map[SHOULD_GZIP_CONTENT] = value
    }

    override fun shouldGZipContent(): Boolean {
        return map.getOrDefault(SHOULD_GZIP_CONTENT, super.shouldGZipContent()) as Boolean
    }

    override fun setRegistryForRemoteRegions(value: String?) {
        map[FETCH_REGISTRY_FOR_REMOTE_REGIONS] = value
    }

    override fun fetchRegistryForRemoteRegions(): String? {
        return map.getOrDefault(FETCH_REGISTRY_FOR_REMOTE_REGIONS, super.fetchRegistryForRemoteRegions()) as String?
    }

    override fun setDollarReplacement(value: String) {
        map[GET_DOLLAR_REPLACEMENT] = value
    }

    override fun getDollarReplacement(): String? {
        return map.getOrDefault(GET_DOLLAR_REPLACEMENT, super.getDollarReplacement()) as String?
    }

    override fun setRegistryFetchIntervalSeconds(value: Int) {
        map[GET_REGISTRY_FETCH_INTERVAL_SECONDS] = value
    }

    override fun getRegistryFetchIntervalSeconds(): Int {
        return map.getOrDefault(
            GET_REGISTRY_FETCH_INTERVAL_SECONDS,
            super.getRegistryFetchIntervalSeconds()
        ) as Int
    }

    override fun setEurekaServerReadTimeoutSeconds(value: Int) {
        map[GET_EUREKA_SERVER_READ_TIMEOUT_SECONDS] = value
    }

    override fun getEurekaServerReadTimeoutSeconds(): Int {
        return map.getOrDefault(
            GET_EUREKA_SERVER_READ_TIMEOUT_SECONDS,
            super.getEurekaServerReadTimeoutSeconds()
        ) as Int
    }

    override fun setClientDataAccept(value: String) {
        map[GET_CLIENT_DATA_ACCEPT] = value
    }

    override fun getClientDataAccept(): String? {
        return map.getOrDefault(GET_CLIENT_DATA_ACCEPT, super.getClientDataAccept()) as String?
    }

    override fun setEscapeCharReplacement(value: String) {
        map[GET_ESCAPE_CHAR_REPLACEMENT] = value
    }

    override fun getEscapeCharReplacement(): String? {
        return map.getOrDefault(GET_ESCAPE_CHAR_REPLACEMENT, super.getEscapeCharReplacement()) as String?
    }

    override fun setAvailabilityZones(value: Array<String>, region: String?) {
        map[GET_AVAILABILITY_ZONES.withKey(region)] = value
    }

    override fun setAvailabilityZones(value: Collection<String>, region: String?) {
        map[GET_AVAILABILITY_ZONES.withKey(region)] = value.toTypedArray()
    }

    @Suppress("UNCHECKED_CAST")
    override fun getAvailabilityZones(region: String?): Array<String> {
        return map.getOrDefault(
            GET_AVAILABILITY_ZONES.withKey(region),
            super.getAvailabilityZones(region)
        ) as Array<String>
    }

    override fun setHeartbeatExecutorExponentialBackOffBound(value: Int) {
        map[GET_HEARTBEAT_EXECUTOR_EXPONENTIAL_BACK_OFF_BOUND] = value
    }

    override fun getHeartbeatExecutorExponentialBackOffBound(): Int {
        return map.getOrDefault(
            GET_HEARTBEAT_EXECUTOR_EXPONENTIAL_BACK_OFF_BOUND,
            super.getHeartbeatExecutorExponentialBackOffBound()
        ) as Int
    }

    override fun setProxyHost(value: String) {
        map[GET_PROXY_HOST] = value
    }

    override fun getProxyHost(): String? {
        return map.getOrDefault(GET_PROXY_HOST, super.getProxyHost()) as String?
    }

    override fun setOnDemandUpdateStatusChange(value: Boolean) {
        map[SHOULD_ON_DEMAND_UPDATE_STATUS_CHANGE] = value
    }

    override fun shouldOnDemandUpdateStatusChange(): Boolean {
        return map.getOrDefault(
            SHOULD_ON_DEMAND_UPDATE_STATUS_CHANGE,
            super.shouldOnDemandUpdateStatusChange()
        ) as Boolean
    }

    override fun setTransportConfig(value: EurekaTransportConfig) {
        map[GET_TRANSPORT_CONFIG] = value
    }

    override fun getTransportConfig(): EurekaTransportConfig? {
        return map.getOrDefault(GET_TRANSPORT_CONFIG, super.getTransportConfig()) as EurekaTransportConfig?
    }

    override fun setProxyUserName(value: String) {
        map[GET_PROXY_USER_NAME] = value
    }

    override fun getProxyUserName(): String? {
        return map.getOrDefault(GET_PROXY_USER_NAME, super.getProxyUserName()) as String?
    }

    override fun setBackupRegistryImpl(value: String) {
        map[GET_BACKUP_REGISTRY_IMPL] = value
    }

    override fun getBackupRegistryImpl(): String? {
        return map.getOrDefault(GET_BACKUP_REGISTRY_IMPL, super.getBackupRegistryImpl()) as String?
    }

    override fun setInitialInstanceInfoReplicationIntervalSeconds(value: Int) {
        map[GET_INITIAL_INSTANCE_INFO_REPLICATION_INTERVAL_SECONDS] = value
    }

    override fun getInitialInstanceInfoReplicationIntervalSeconds(): Int {
        return map.getOrDefault(
            GET_INITIAL_INSTANCE_INFO_REPLICATION_INTERVAL_SECONDS,
            super.getInitialInstanceInfoReplicationIntervalSeconds()
        ) as Int
    }

    override fun setDecoderName(value: String) {
        map[GET_DECODER_NAME] = value
    }

    override fun getDecoderName(): String? = map.getOrDefault(GET_DECODER_NAME, super.getDecoderName()) as String?

    override fun setPreferSameZoneEureka(value: Boolean) {
        map[SHOULD_PREFER_SAME_ZONE_EUREKA] = value
    }

    override fun shouldPreferSameZoneEureka(): Boolean {
        return map.getOrDefault(SHOULD_PREFER_SAME_ZONE_EUREKA, super.shouldPreferSameZoneEureka()) as Boolean
    }

    override fun enableFetchRegistry(value: Boolean) {
        map[SHOULD_FETCH_REGISTRY] = value
    }

    override fun shouldFetchRegistry(): Boolean {
        return map.getOrDefault(SHOULD_FETCH_REGISTRY, super.shouldFetchRegistry()) as Boolean
    }

    override fun enableEnforceRegistrationAtInit(value: Boolean) {
        map[SHOULD_ENFORCE_REGISTRATION_AT_INIT] = value
    }

    override fun shouldEnforceRegistrationAtInit(): Boolean {
        return map.getOrDefault(
            SHOULD_ENFORCE_REGISTRATION_AT_INIT,
            super<DefaultEurekaClientConfig>.shouldEnforceRegistrationAtInit()
        ) as Boolean
    }

    override fun setEurekaServerURLContext(value: String) {
        map[GET_EUREKA_SERVER_URLCONTEXT] = value
    }

    override fun getEurekaServerURLContext(): String? {
        return map.getOrDefault(GET_EUREKA_SERVER_URLCONTEXT, super.getEurekaServerURLContext()) as String?
    }

    override fun setRegistryRefreshSingleVipAddress(value: String?) {
        map[GET_REGISTRY_REFRESH_SINGLE_VIP_ADDRESS] = value
    }

    override fun getRegistryRefreshSingleVipAddress(): String? {
        return map.getOrDefault(
            GET_REGISTRY_REFRESH_SINGLE_VIP_ADDRESS,
            super.getRegistryRefreshSingleVipAddress()
        ) as String?
    }

    override fun setRegion(value: String) {
        map[GET_REGION] = value
    }

    override fun getRegion(): String? {
        return map.getOrDefault(GET_REGION, super.getRegion()) as String?
    }

    override fun setEurekaServerDNSName(value: String) {
        map[GET_EUREKA_SERVER_DNSNAME] = value
    }

    override fun getEurekaServerDNSName(): String? {
        return map.getOrDefault(GET_EUREKA_SERVER_DNSNAME, super.getEurekaServerDNSName()) as String?
    }

    override fun enableUseDnsForFetchingServiceUrls(value: Boolean) {
        map[SHOULD_USE_DNS_FOR_FETCHING_SERVICE_URLS] = value
    }

    override fun shouldUseDnsForFetchingServiceUrls(): Boolean {
        return map.getOrDefault(
            SHOULD_USE_DNS_FOR_FETCHING_SERVICE_URLS,
            super.shouldUseDnsForFetchingServiceUrls()
        ) as Boolean
    }

    override fun setEncoderName(value: String) {
        map[GET_ENCODER_NAME] = value
    }

    override fun getEncoderName(): String? {
        return map.getOrDefault(GET_ENCODER_NAME, super.getEncoderName()) as String?
    }

    override fun setProxyPassword(value: String) {
        map[GET_PROXY_PASSWORD] = value
    }

    override fun getProxyPassword(): String? {
        return map.getOrDefault(GET_PROXY_PASSWORD, super.getProxyPassword()) as String?
    }

    override fun setEurekaServerConnectTimeoutSeconds(value: Int) {
        map[GET_EUREKA_SERVER_CONNECT_TIMEOUT_SECONDS] = value
    }

    override fun getEurekaServerConnectTimeoutSeconds(): Int {
        return map.getOrDefault(
            GET_EUREKA_SERVER_CONNECT_TIMEOUT_SECONDS,
            super.getEurekaServerConnectTimeoutSeconds()
        ) as Int
    }

    override fun setEurekaServerPort(value: String) {
        map[GET_EUREKA_SERVER_PORT] = value
    }

    override fun getEurekaServerPort(): String? {
        return map.getOrDefault(GET_EUREKA_SERVER_PORT, super.getEurekaServerPort()) as String?
    }

    override fun setFilterOnlyUpInstances(value: Boolean) {
        map[SHOULD_FILTER_ONLY_UP_INSTANCES] = value
    }

    override fun shouldFilterOnlyUpInstances(): Boolean {
        return map.getOrDefault(SHOULD_FILTER_ONLY_UP_INSTANCES, super.shouldFilterOnlyUpInstances()) as Boolean
    }

    override fun setEurekaConnectionIdleTimeoutSeconds(value: Int) {
        map[GET_EUREKA_CONNECTION_IDLE_TIMEOUT_SECONDS] = value
    }

    override fun getEurekaConnectionIdleTimeoutSeconds(): Int {
        return map.getOrDefault(
            GET_EUREKA_CONNECTION_IDLE_TIMEOUT_SECONDS,
            super.getEurekaConnectionIdleTimeoutSeconds()
        ) as Int
    }

    override fun setCacheRefreshExecutorThreadPoolSize(value: Int) {
        map[GET_CACHE_REFRESH_EXECUTOR_THREAD_POOL_SIZE] = value
    }

    override fun getCacheRefreshExecutorThreadPoolSize(): Int {
        return map.getOrDefault(
            GET_CACHE_REFRESH_EXECUTOR_THREAD_POOL_SIZE,
            super.getCacheRefreshExecutorThreadPoolSize()
        ) as Int
    }

    override fun setCacheRefreshExecutorExponentialBackOffBound(value: Int) {
        map[GET_CACHE_REFRESH_EXECUTOR_EXPONENTIAL_BACK_OFF_BOUND] = value
    }

    override fun getCacheRefreshExecutorExponentialBackOffBound(): Int {
        return map.getOrDefault(
            GET_CACHE_REFRESH_EXECUTOR_EXPONENTIAL_BACK_OFF_BOUND,
            super.getCacheRefreshExecutorExponentialBackOffBound()
        ) as Int
    }

    override fun setInstanceInfoReplicationIntervalSeconds(value: Int) {
        map[GET_INSTANCE_INFO_REPLICATION_INTERVAL_SECONDS] = value
    }

    override fun getInstanceInfoReplicationIntervalSeconds(): Int {
        return map.getOrDefault(
            GET_INSTANCE_INFO_REPLICATION_INTERVAL_SECONDS,
            super.getInstanceInfoReplicationIntervalSeconds()
        ) as Int
    }

    override fun setEurekaServerTotalConnections(value: Int) {
        map[GET_EUREKA_SERVER_TOTAL_CONNECTIONS] = value
    }

    override fun getEurekaServerTotalConnections(): Int {
        return map.getOrDefault(GET_EUREKA_SERVER_TOTAL_CONNECTIONS, super.getEurekaServerTotalConnections()) as Int
    }

    override fun enableAllowRedirects(value: Boolean) {
        map[ALLOW_REDIRECTS] = value
    }

    override fun allowRedirects(): Boolean {
        return map.getOrDefault(ALLOW_REDIRECTS, super.allowRedirects()) as Boolean
    }

    override fun enableRegisterWithEureka(value: Boolean) {
        map[SHOULD_REGISTER_WITH_EUREKA] = value
    }

    override fun shouldRegisterWithEureka(): Boolean {
        return map.getOrDefault(SHOULD_REGISTER_WITH_EUREKA, super.shouldRegisterWithEureka()) as Boolean
    }

    override fun setEurekaServiceUrlPollIntervalSeconds(value: Int) {
        map[GET_EUREKA_SERVICE_URL_POLL_INTERVAL_SECONDS] = value
    }

    override fun getEurekaServiceUrlPollIntervalSeconds(): Int {
        return map.getOrDefault(
            GET_EUREKA_SERVICE_URL_POLL_INTERVAL_SECONDS,
            super.getEurekaServiceUrlPollIntervalSeconds()
        ) as Int
    }

    override fun setProxyPort(value: String) {
        map[GET_PROXY_PORT] = value
    }

    override fun getProxyPort(): String? {
        return map.getOrDefault(GET_PROXY_PORT, super.getProxyPort()) as String?
    }

    override fun enableLogDeltaDiff(value: Boolean) {
        map[SHOULD_LOG_DELTA_DIFF] = value
    }

    override fun shouldLogDeltaDiff(): Boolean {
        return map.getOrDefault(SHOULD_LOG_DELTA_DIFF, super.shouldLogDeltaDiff()) as Boolean
    }

    override fun setExperimental(name: String?, value: String) {
        map[GET_EXPERIMENTAL.withKey(name)] = value   // todo
    }

    override fun getExperimental(name: String?): String? {
        return map.getOrDefault(GET_EXPERIMENTAL.withKey(name), super.getExperimental(name)) as String?
    }

    override fun enableDisableDelta(value: Boolean) {
        map[SHOULD_DISABLE_DELTA] = value
    }

    override fun shouldDisableDelta(): Boolean {
        return map.getOrDefault(SHOULD_DISABLE_DELTA, super.shouldDisableDelta()) as Boolean
    }

    override fun setEurekaServerServiceUrls(value: List<String>, myZone: String) {
        map[GET_EUREKA_SERVER_SERVICE_URLS.withKey(myZone)] = value
    }

    @Suppress("UNCHECKED_CAST")
    override fun getEurekaServerServiceUrls(myZone: String?): List<String> {
        return (map.getOrDefault(
            GET_EUREKA_SERVER_SERVICE_URLS.withKey(myZone),
            super.getEurekaServerServiceUrls(myZone)
        ) ?: emptyList<String>()) as MutableList<String>
    }

}

private enum class EurekaPropertyKey {
    GET_HEARTBEAT_EXECUTOR_THREAD_POOL_SIZE,
    GET_EUREKA_SERVER_TOTAL_CONNECTIONS_PER_HOST,
    SHOULD_UNREGISTER_ON_SHUTDOWN,
    SHOULD_GZIP_CONTENT,
    FETCH_REGISTRY_FOR_REMOTE_REGIONS,
    GET_DOLLAR_REPLACEMENT,
    GET_REGISTRY_FETCH_INTERVAL_SECONDS,
    GET_EUREKA_SERVER_READ_TIMEOUT_SECONDS,
    GET_CLIENT_DATA_ACCEPT,
    GET_ESCAPE_CHAR_REPLACEMENT,
    GET_AVAILABILITY_ZONES,
    GET_HEARTBEAT_EXECUTOR_EXPONENTIAL_BACK_OFF_BOUND,
    GET_PROXY_HOST,
    SHOULD_ON_DEMAND_UPDATE_STATUS_CHANGE,
    GET_TRANSPORT_CONFIG,
    GET_PROXY_USER_NAME,
    GET_BACKUP_REGISTRY_IMPL,
    GET_INITIAL_INSTANCE_INFO_REPLICATION_INTERVAL_SECONDS,
    GET_DECODER_NAME,
    SHOULD_PREFER_SAME_ZONE_EUREKA,
    SHOULD_FETCH_REGISTRY,
    SHOULD_ENFORCE_REGISTRATION_AT_INIT,
    GET_EUREKA_SERVER_URLCONTEXT,
    GET_REGISTRY_REFRESH_SINGLE_VIP_ADDRESS,
    GET_REGION,
    GET_EUREKA_SERVER_DNSNAME,
    SHOULD_USE_DNS_FOR_FETCHING_SERVICE_URLS,
    GET_ENCODER_NAME,
    GET_PROXY_PASSWORD,
    GET_EUREKA_SERVER_CONNECT_TIMEOUT_SECONDS,
    GET_EUREKA_SERVER_PORT,
    SHOULD_FILTER_ONLY_UP_INSTANCES,
    GET_EUREKA_CONNECTION_IDLE_TIMEOUT_SECONDS,
    GET_CACHE_REFRESH_EXECUTOR_THREAD_POOL_SIZE,
    GET_CACHE_REFRESH_EXECUTOR_EXPONENTIAL_BACK_OFF_BOUND,
    GET_INSTANCE_INFO_REPLICATION_INTERVAL_SECONDS,
    GET_EUREKA_SERVER_TOTAL_CONNECTIONS,
    ALLOW_REDIRECTS,
    SHOULD_REGISTER_WITH_EUREKA,
    GET_EUREKA_SERVICE_URL_POLL_INTERVAL_SECONDS,
    GET_PROXY_PORT,
    SHOULD_LOG_DELTA_DIFF,
    GET_EXPERIMENTAL,
    SHOULD_DISABLE_DELTA,
    GET_EUREKA_SERVER_SERVICE_URLS;

    private var key: String? = null

    fun withKey(key: String?) = this.apply { this.key = key }
}
