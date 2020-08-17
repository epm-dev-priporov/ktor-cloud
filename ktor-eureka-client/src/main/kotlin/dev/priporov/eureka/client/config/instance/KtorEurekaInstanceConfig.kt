package dev.priporov.eureka.client.config.instance

import com.netflix.appinfo.DataCenterInfo
import com.netflix.appinfo.EurekaInstanceConfig

interface KtorEurekaInstanceConfig: EurekaInstanceConfig {

    fun setNonSecurePortEnabled(value: Boolean)
    fun setSecureHealthCheckUrl(value: String)
    fun setAppname(value: String)
    fun setMetadataMap(value: MutableMap<String, String>)
    fun setIpAddress(value: String)
    fun setLeaseRenewalIntervalInSeconds(value: Int)
    fun setNonSecurePort(value: Int)
    fun setInstanceEnabledOnit(value: Boolean)
    fun setSecurePort(value: Int)
    fun setSecurePortEnabled(value: Boolean)
    fun setASGName(value: String)
    fun setStatusPageUrlPath(value: String)
    fun setHealthCheckUrl(value: String)
    fun setHomePageUrlPath(value: String)
    fun setNamespace(value: String)
    fun setHomePageUrl(value: String)
    fun setLeaseExpirationDurationInSeconds(value: Int)
    fun setInstanceId(value: String)
    fun setDefaultAddressResolutionOrder(value: Array<String>)
    fun setAppGroupName(value: String)
    fun setVirtualHostName(value: String?)
    fun setHostName(value: String?)
    fun setStatusPageUrl(value: String)
    fun setDataCenterInfo(value: DataCenterInfo)
    fun setSecureVirtualHostName(value: String?)
    fun setHealthCheckUrlPath(value: String)

}
