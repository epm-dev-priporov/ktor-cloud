package dev.priporov.eureka.client.config.instance

import com.netflix.appinfo.DataCenterInfo
import com.netflix.appinfo.MyDataCenterInstanceConfig
import dev.priporov.eureka.client.config.instance.EurekaPropertyKey.*

class KtorInstanceConfig : MyDataCenterInstanceConfig(), KtorEurekaInstanceConfig {
    private val map = HashMap<EurekaPropertyKey, Any?>()

    override fun setNonSecurePortEnabled(value: Boolean) {
        map[IS_NON_SECURE_PORT_ENABLED] = value
    }

    override fun isNonSecurePortEnabled(): Boolean {
        return map.getOrDefault(IS_NON_SECURE_PORT_ENABLED, super.isNonSecurePortEnabled()) as Boolean
    }

    override fun setStatusPageUrl(value: String) {
        map[STATUS_PAGE_URL] = value
    }

    override fun getStatusPageUrl(): String? {
        return map.getOrDefault(STATUS_PAGE_URL, super.getStatusPageUrl()) as String?
    }

    override fun setSecureHealthCheckUrl(value: String) {
        map[SECURE_HEALTH_CHECK_URL] = value
    }

    override fun getSecureHealthCheckUrl(): String? {
        return map.getOrDefault(SECURE_HEALTH_CHECK_URL, super.getSecureHealthCheckUrl()) as String?
    }

    override fun setAppname(value: String) {
        map[APPNAME] = value
    }

    override fun getAppname(): String? {
        return map.getOrDefault(APPNAME, super.getAppname()) as String?
    }

    override fun setMetadataMap(value: MutableMap<String, String>) {
        map[METADATA_MAP] = value
    }

    override fun getMetadataMap(): MutableMap<String, String>? {
        return map.getOrDefault(METADATA_MAP, super.getMetadataMap()) as MutableMap<String, String>?
    }

    override fun setIpAddress(value: String) {
        map[IP_ADDRESS] = value
    }

    override fun getIpAddress(): String? {
        return map.getOrDefault(IP_ADDRESS, super.getIpAddress()) as String?
    }

    override fun setLeaseRenewalIntervalInSeconds(value: Int) {
        map[LEASE_RENEWAL_INTERVAL_IN_SECONDS] = value
    }

    override fun getLeaseRenewalIntervalInSeconds(): Int {
        return map.getOrDefault(LEASE_RENEWAL_INTERVAL_IN_SECONDS, super.getLeaseRenewalIntervalInSeconds()) as Int
    }

    override fun setDataCenterInfo(value: DataCenterInfo) {
        map[DATA_CENTER_INFO] = value
    }

    override fun getDataCenterInfo(): DataCenterInfo? {
        return map.getOrDefault(DATA_CENTER_INFO, super.getDataCenterInfo()) as DataCenterInfo?
    }

    override fun setNonSecurePort(value: Int) {
        map[NON_SECURE_PORT] = value
    }

    override fun getNonSecurePort(): Int {
        return map.getOrDefault(NON_SECURE_PORT, super.getNonSecurePort()) as Int
    }


    override fun setInstanceEnabledOnit(value: Boolean) {
        map[IS_INSTANCE_ENABLED_ONIT] = value
    }

    override fun isInstanceEnabledOnit(): Boolean {
        return map.getOrDefault(IS_INSTANCE_ENABLED_ONIT, super.isInstanceEnabledOnit()) as Boolean
    }

    override fun setSecureVirtualHostName(value: String?) {
        map[SECURE_VIRTUAL_HOST_NAME] = value
    }

    override fun getSecureVirtualHostName(): String? {
        return map.getOrDefault(SECURE_VIRTUAL_HOST_NAME, super.getSecureVirtualHostName()) as String?
    }

    override fun setSecurePort(value: Int) {
        map[SECURE_PORT] = value
    }

    override fun getSecurePort(): Int {
        return map.getOrDefault(SECURE_PORT, super.getSecurePort()) as Int
    }

    override fun setSecurePortEnabled(value: Boolean) {
        map[SECURE_PORT_ENABLED] = value
    }

    override fun getSecurePortEnabled(): Boolean {
        return map.getOrDefault(SECURE_PORT_ENABLED, super.getSecurePortEnabled()) as Boolean
    }

    override fun setASGName(value: String) {
        map[ASG_NAME] = value
    }

    override fun getASGName(): String? {
        return map.getOrDefault(ASG_NAME, super.getASGName()) as String?
    }

    override fun setStatusPageUrlPath(value: String) {
        map[STATUS_PAGE_URL_PATH] = value
    }

    override fun getStatusPageUrlPath(): String? {
        return map.getOrDefault(STATUS_PAGE_URL_PATH, super.getStatusPageUrlPath()) as String?
    }

    override fun setHealthCheckUrl(value: String) {
        map[HEALTH_CHECK_URL] = value
    }

    override fun getHealthCheckUrl(): String? {
        return map.getOrDefault(HEALTH_CHECK_URL, super.getHealthCheckUrl()) as String?
    }

    override fun setHomePageUrlPath(value: String) {
        map[HOME_PAGE_URL_PATH] = value
    }

    override fun getHomePageUrlPath(): String? {
        return map.getOrDefault(HOME_PAGE_URL_PATH, super.getHomePageUrlPath()) as String?
    }

    override fun setNamespace(value: String) {
        map[NAMESPACE] = value
    }

    override fun getNamespace(): String? {
        return map.getOrDefault(NAMESPACE, super.getNamespace()) as String?
    }

    override fun setHomePageUrl(value: String) {
        map[HOME_PAGE_URL] = value
    }

    override fun getHomePageUrl(): String? {
        return map.getOrDefault(HOME_PAGE_URL, super.getHomePageUrl()) as String?
    }

    override fun setLeaseExpirationDurationInSeconds(value: Int) {
        map[LEASE_EXPIRATION_DURATION_IN_SECONDS] = value
    }

    override fun getLeaseExpirationDurationInSeconds(): Int {
        return map.getOrDefault(
            LEASE_EXPIRATION_DURATION_IN_SECONDS,
            super.getLeaseExpirationDurationInSeconds()
        ) as Int
    }

    override fun setInstanceId(value: String) {
        map[INSTANCE_ID] = value
    }

    override fun getInstanceId(): String? {
        return map.getOrDefault(INSTANCE_ID, super.getInstanceId()) as String?
    }

    override fun setDefaultAddressResolutionOrder(value: Array<String>) {
        map[DEFAULT_ADDRESS_RESOLUTION_ORDER] = value
    }

    override fun getDefaultAddressResolutionOrder(): Array<String>? {
        return map.getOrDefault(
            DEFAULT_ADDRESS_RESOLUTION_ORDER,
            super.getDefaultAddressResolutionOrder()
        ) as Array<String>?
    }

    override fun setAppGroupName(value: String) {
        map[APP_GROUP_NAME] = value
    }

    override fun getAppGroupName(): String? {
        return map.getOrDefault(APP_GROUP_NAME, super.getAppGroupName()) as String?
    }

    override fun setVirtualHostName(value: String?) {
        map[VIRTUAL_HOST_NAME] = value
    }

    override fun getVirtualHostName(): String? {
        return map.getOrDefault(VIRTUAL_HOST_NAME, null) as String?
    }

    override fun setHealthCheckUrlPath(value: String) {
        map[HEALTH_CHECK_URL_PATH] = value
    }

    override fun getHealthCheckUrlPath(): String? {
        return map.getOrDefault(HEALTH_CHECK_URL_PATH, super.getHealthCheckUrlPath()) as String?
    }

    override fun getHostName(refresh: Boolean): String? {
        return map.getOrDefault(HOST_NAME, super.getHostName(refresh)) as String?
    }

    override fun setHostName(value: String?) {
        map[HOST_NAME] = value
    }
}

private enum class EurekaPropertyKey {
    IS_NON_SECURE_PORT_ENABLED,
    STATUS_PAGE_URL,
    SECURE_HEALTH_CHECK_URL,
    APPNAME,
    METADATA_MAP,
    IP_ADDRESS,
    LEASE_RENEWAL_INTERVAL_IN_SECONDS,
    DATA_CENTER_INFO,
    NON_SECURE_PORT,
    IS_INSTANCE_ENABLED_ONIT,
    SECURE_VIRTUAL_HOST_NAME,
    SECURE_PORT,
    SECURE_PORT_ENABLED,
    ASG_NAME,
    STATUS_PAGE_URL_PATH,
    HEALTH_CHECK_URL,
    HOME_PAGE_URL_PATH,
    NAMESPACE,
    HOME_PAGE_URL,
    LEASE_EXPIRATION_DURATION_IN_SECONDS,
    INSTANCE_ID,
    DEFAULT_ADDRESS_RESOLUTION_ORDER,
    APP_GROUP_NAME,
    VIRTUAL_HOST_NAME,
    HEALTH_CHECK_URL_PATH,
    HOST_NAME
}
