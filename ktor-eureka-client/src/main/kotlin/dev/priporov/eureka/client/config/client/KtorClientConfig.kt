package dev.priporov.eureka.client.config.client

import com.netflix.discovery.DefaultEurekaClientConfig
import com.netflix.discovery.shared.transport.EurekaTransportConfig
import dev.priporov.eureka.client.config.client.EurekaPropertyKey.*


class KtorClientConfig : DefaultEurekaClientConfig(), KtorEurekaClientConfig {
    private val map = HashMap<EurekaPropertyKey, Any?>()

    override fun setHeartbeatExecutorThreadPoolSize(value: Int){
        map[GET_HEARTBEAT_EXECUTOR_THREAD_POOL_SIZE] = value
    }

    override fun getHeartbeatExecutorThreadPoolSize(): Int {
        return super.getHeartbeatExecutorThreadPoolSize()
    }

    override fun setEurekaServerTotalConnectionsPerHost(value: Int){
        map[GET_EUREKA_SERVER_TOTAL_CONNECTIONS_PER_HOST] = value
    }

    override fun getEurekaServerTotalConnectionsPerHost(): Int {
        return super.getEurekaServerTotalConnectionsPerHost()
    }

    override fun enableUnregisterOnShutdown(value: Boolean){
        map[SHOULD_UNREGISTER_ON_SHUTDOWN] = value
    }

    override fun shouldUnregisterOnShutdown(): Boolean {
        return super.shouldUnregisterOnShutdown()
    }

    override fun setGZipContent(value: Boolean){
        map[SHOULD_GZIP_CONTENT] = value
    }

    override fun shouldGZipContent(): Boolean {
        return super.shouldGZipContent()
    }

    override fun setRegistryForRemoteRegions(value: String?){
        map[FETCH_REGISTRY_FOR_REMOTE_REGIONS] = value
    }

    override fun fetchRegistryForRemoteRegions(): String? {
        return super.fetchRegistryForRemoteRegions()
    }

    override fun setDollarReplacement(value: String){
        map[GET_DOLLAR_REPLACEMENT] = value
    }

    override fun getDollarReplacement(): String {
        return super.getDollarReplacement()
    }

    override fun setRegistryFetchIntervalSeconds(value: Int){
        map[GET_REGISTRY_FETCH_INTERVAL_SECONDS] = value
    }

    override fun getRegistryFetchIntervalSeconds(): Int {
        return super.getRegistryFetchIntervalSeconds()
    }

    override fun setEurekaServerReadTimeoutSeconds(value: Int){
        map[GET_EUREKA_SERVER_READ_TIMEOUT_SECONDS] = value
    }

    override fun getEurekaServerReadTimeoutSeconds(): Int {
        return super.getEurekaServerReadTimeoutSeconds()
    }

    override fun setClientDataAccept(value: String){
        map[GET_CLIENT_DATA_ACCEPT] = value
    }

    override fun getClientDataAccept(): String {
        return super.getClientDataAccept()
    }

    override fun setEscapeCharReplacement(value: String){
        map[GET_ESCAPE_CHAR_REPLACEMENT] = value
    }

    override fun getEscapeCharReplacement(): String {
        return super.getEscapeCharReplacement()
    }

    override fun setAvailabilityZones(value: Array<String>, region: String?){
        map[GET_AVAILABILITY_ZONES] = value // todo
    }

    override fun getAvailabilityZones(region: String?): Array<String> {
        return super.getAvailabilityZones(region)
    }

    override fun setHeartbeatExecutorExponentialBackOffBound(value: Int){
        map[GET_HEARTBEAT_EXECUTOR_EXPONENTIAL_BACK_OFF_BOUND] = value
    }

    override fun getHeartbeatExecutorExponentialBackOffBound(): Int {
        return super.getHeartbeatExecutorExponentialBackOffBound()
    }

    override fun setProxyHost(value: String){
        map[GET_PROXY_HOST] = value
    }

    override fun getProxyHost(): String {
        return super.getProxyHost()
    }

    override fun setOnDemandUpdateStatusChange(value: Boolean){
        map[SHOULD_ON_DEMAND_UPDATE_STATUS_CHANGE] = value
    }

    override fun shouldOnDemandUpdateStatusChange(): Boolean {
        return super.shouldOnDemandUpdateStatusChange()
    }

    override fun setTransportConfig(value: EurekaTransportConfig){
        map[GET_TRANSPORT_CONFIG] = value
    }

    override fun getTransportConfig(): EurekaTransportConfig {
        return super.getTransportConfig()
    }

    override fun setProxyUserName(value: String){
        map[GET_PROXY_USER_NAME] = value
    }

    override fun getProxyUserName(): String {
        return super.getProxyUserName()
    }

    override fun setBackupRegistryImpl(value: String){
        map[GET_BACKUP_REGISTRY_IMPL] = value
    }

    override fun getBackupRegistryImpl(): String {
        return super.getBackupRegistryImpl()
    }

    override fun setInitialInstanceInfoReplicationIntervalSeconds(value: Int){
        map[GET_INITIAL_INSTANCE_INFO_REPLICATION_INTERVAL_SECONDS] = value
    }

    override fun getInitialInstanceInfoReplicationIntervalSeconds(): Int {
        return super.getInitialInstanceInfoReplicationIntervalSeconds()
    }

    override fun setDecoderName(value: String){
        map[GET_DECODER_NAME] = value
    }

    override fun getDecoderName(): String {
        return super.getDecoderName()
    }

    override fun setPreferSameZoneEureka(value: Boolean){
        map[SHOULD_PREFER_SAME_ZONE_EUREKA] = value
    }

    override fun shouldPreferSameZoneEureka(): Boolean {
        return super.shouldPreferSameZoneEureka()
    }

    override fun enableFetchRegistry(value: Boolean){
        map[SHOULD_FETCH_REGISTRY] = value
    }

    override fun shouldFetchRegistry(): Boolean {
        return super.shouldFetchRegistry()
    }

    override fun enableEnforceRegistrationAtInit(value: Boolean){
        map[SHOULD_ENFORCE_REGISTRATION_AT_INIT] = value
    }

    override fun shouldEnforceRegistrationAtInit(): Boolean {
        return super.shouldEnforceRegistrationAtInit()
    }

    override fun setEurekaServerURLContext(value: String){
        map[GET_EUREKA_SERVER_URLCONTEXT] = value
    }

    override fun getEurekaServerURLContext(): String {
        return super.getEurekaServerURLContext()
    }

    override fun setRegistryRefreshSingleVipAddress(value: String?) {
        map[GET_REGISTRY_REFRESH_SINGLE_VIP_ADDRESS] = value
    }

    override fun getRegistryRefreshSingleVipAddress(): String? {
        return super.getRegistryRefreshSingleVipAddress()
    }

    override fun setRegion(value: String){
        map[GET_REGION] = value
    }

    override fun getRegion(): String {
        return super.getRegion()
    }

    override fun setEurekaServerDNSName(value: String){
        map[GET_EUREKA_SERVER_DNSNAME] = value
    }

    override fun getEurekaServerDNSName(): String {
        return super.getEurekaServerDNSName()
    }

    override fun enableUseDnsForFetchingServiceUrls(value: Boolean){
        map[SHOULD_USE_DNS_FOR_FETCHING_SERVICE_URLS] = value
    }

    override fun shouldUseDnsForFetchingServiceUrls(): Boolean {
        return super.shouldUseDnsForFetchingServiceUrls()
    }

    override fun setEncoderName(value: String){
        map[GET_ENCODER_NAME] = value
    }

    override fun getEncoderName(): String {
        return super.getEncoderName()
    }

    override fun setProxyPassword(value: String){
        map[GET_PROXY_PASSWORD] = value
    }

    override fun getProxyPassword(): String {
        return super.getProxyPassword()
    }

    override fun setEurekaServerConnectTimeoutSeconds(value: Int){
        map[GET_EUREKA_SERVER_CONNECT_TIMEOUT_SECONDS] = value
    }

    override fun getEurekaServerConnectTimeoutSeconds(): Int {
        return super.getEurekaServerConnectTimeoutSeconds()
    }

    override fun setEurekaServerPort(value: String){
        map[GET_EUREKA_SERVER_PORT] = value
    }

    override fun getEurekaServerPort(): String {
        return super.getEurekaServerPort()
    }

    override fun setFilterOnlyUpInstances(value: Boolean){
        map[SHOULD_FILTER_ONLY_UP_INSTANCES] = value
    }

    override fun shouldFilterOnlyUpInstances(): Boolean {
        return super.shouldFilterOnlyUpInstances()
    }

    override fun setEurekaConnectionIdleTimeoutSeconds(value: Int){
        map[GET_EUREKA_CONNECTION_IDLE_TIMEOUT_SECONDS] = value
    }

    override fun getEurekaConnectionIdleTimeoutSeconds(): Int {
        return super.getEurekaConnectionIdleTimeoutSeconds()
    }

    override fun setCacheRefreshExecutorThreadPoolSize(value: Int){
        map[GET_CACHE_REFRESH_EXECUTOR_THREAD_POOL_SIZE] = value
    }

    override fun getCacheRefreshExecutorThreadPoolSize(): Int {
        return super.getCacheRefreshExecutorThreadPoolSize()
    }

    override fun setCacheRefreshExecutorExponentialBackOffBound(value: Int){
        map[GET_CACHE_REFRESH_EXECUTOR_EXPONENTIAL_BACK_OFF_BOUND] = value
    }

    override fun getCacheRefreshExecutorExponentialBackOffBound(): Int {
        return super.getCacheRefreshExecutorExponentialBackOffBound()
    }

    override fun setInstanceInfoReplicationIntervalSeconds(value: Int){
        map[GET_INSTANCE_INFO_REPLICATION_INTERVAL_SECONDS] = value
    }

    override fun getInstanceInfoReplicationIntervalSeconds(): Int {
        return super.getInstanceInfoReplicationIntervalSeconds()
    }

    override fun setEurekaServerTotalConnections(value: Int){
        map[GET_EUREKA_SERVER_TOTAL_CONNECTIONS] = value
    }

    override fun getEurekaServerTotalConnections(): Int {
        return super.getEurekaServerTotalConnections()
    }

    override fun enableAllowRedirects(value: Boolean){
        map[ALLOW_REDIRECTS] = value
    }

    override fun allowRedirects(): Boolean {
        return super.allowRedirects()
    }

    override fun enableRegisterWithEureka(value: Boolean){
        map[SHOULD_REGISTER_WITH_EUREKA] = value
    }

    override fun shouldRegisterWithEureka(): Boolean {
        return super.shouldRegisterWithEureka()
    }

    override fun setEurekaServiceUrlPollIntervalSeconds(value: Int){
        map[GET_EUREKA_SERVICE_URL_POLL_INTERVAL_SECONDS] = value
    }

    override fun getEurekaServiceUrlPollIntervalSeconds(): Int {
        return super.getEurekaServiceUrlPollIntervalSeconds()
    }

    override fun setProxyPort(value: String){
        map[GET_PROXY_PORT] = value
    }

    override fun getProxyPort(): String {
        return super.getProxyPort()
    }

    override fun enableLogDeltaDiff(value: Boolean){
        map[SHOULD_LOG_DELTA_DIFF] = value
    }

    override fun shouldLogDeltaDiff(): Boolean {
        return super.shouldLogDeltaDiff()
    }

    override fun setExperimental(name: String?, value: String){
        map[GET_EXPERIMENTAL] = value   // todo
    }

    override fun getExperimental(name: String?): String {
        return super.getExperimental(name)
    }

    override fun enableDisableDelta(value: Boolean){
        map[SHOULD_DISABLE_DELTA] = value
    }

    override fun shouldDisableDelta(): Boolean {
        return super.shouldDisableDelta()
    }

    override fun setEurekaServerServiceUrls(value: MutableList<String> , myZone: String?) {
        map[GET_EUREKA_SERVER_SERVICE_URLS] = value
    }

    override fun getEurekaServerServiceUrls(myZone: String?): MutableList<String> {
        return super.getEurekaServerServiceUrls(myZone)
    }

}

private enum class EurekaPropertyKey{
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
    GET_EUREKA_SERVER_SERVICE_URLS,
}
