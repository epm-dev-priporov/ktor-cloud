package dev.priporov.eureka.client.config.instance

import com.netflix.appinfo.DataCenterInfo
import com.netflix.appinfo.MyDataCenterInstanceConfig

class KtorInstanceConfig : MyDataCenterInstanceConfig(), KtorEurekaInstanceConfig {

    private var nonSecurePortEnabled = super.isNonSecurePortEnabled()
    override fun setNonSecurePortEnabled(value: Boolean) { nonSecurePortEnabled = value }
    override fun isNonSecurePortEnabled(): Boolean = nonSecurePortEnabled

    private var statusPageUrl = super.getStatusPageUrl()
    override fun setStatusPageUrl(value: String) { statusPageUrl = value }
    override fun getStatusPageUrl(): String? = statusPageUrl

    private var secureHealthCheckUrl = super.getSecureHealthCheckUrl()
    override fun setSecureHealthCheckUrl(value: String) { secureHealthCheckUrl = value }
    override fun getSecureHealthCheckUrl(): String? = secureHealthCheckUrl

    private var appname = super.getAppname()
    override fun setAppname(value: String) { appname = value }
    override fun getAppname(): String? = appname

    private var metadataMap = super.getMetadataMap()
    override fun setMetadataMap(value: MutableMap<String, String>) { metadataMap = value }
    override fun getMetadataMap(): MutableMap<String, String>? = metadataMap

    private var ipAddress = super.getIpAddress()
    override fun setIpAddress(value: String) { ipAddress = value }
    override fun getIpAddress(): String? = ipAddress

    private var leaseRenewalIntervalInSeconds = super.getLeaseRenewalIntervalInSeconds()
    override fun setLeaseRenewalIntervalInSeconds(value: Int) { leaseRenewalIntervalInSeconds = value }
    override fun getLeaseRenewalIntervalInSeconds(): Int = leaseRenewalIntervalInSeconds

    private var dataCenterInfo = super.getDataCenterInfo()
    override fun setDataCenterInfo(value: DataCenterInfo) { dataCenterInfo = value }
    override fun getDataCenterInfo(): DataCenterInfo? = dataCenterInfo

    private var nonSecurePort = super.getNonSecurePort()
    override fun setNonSecurePort(value: Int) { nonSecurePort = value }
    override fun getNonSecurePort(): Int = nonSecurePort

    private var instanceEnabledOnit = super.isInstanceEnabledOnit()

    override fun setInstanceEnabledOnit(value: Boolean) { instanceEnabledOnit = value }
    override fun isInstanceEnabledOnit(): Boolean = instanceEnabledOnit

    private var secureVirtualHostName = super.getSecureVirtualHostName()
    override fun setSecureVirtualHostName(value: String?) { secureVirtualHostName = value }
    override fun getSecureVirtualHostName(): String? = secureVirtualHostName

    private var securePort = super.getSecurePort()
    override fun setSecurePort(value: Int) { securePort = value }
    override fun getSecurePort(): Int = securePort

    private var securePortEnabled = super.getSecurePortEnabled()
    override fun setSecurePortEnabled(value: Boolean) { securePortEnabled = value }
    override fun getSecurePortEnabled(): Boolean = securePortEnabled

    private var asgname = super.getASGName()
    override fun setASGName(value: String) { asgname = value }
    override fun getASGName(): String? = asgname

    private var statusPageUrlPath = super.getStatusPageUrlPath()
    override fun setStatusPageUrlPath(value: String) { statusPageUrlPath = value }
    override fun getStatusPageUrlPath(): String? = statusPageUrlPath

    private var healthCheckUrl = super.getHealthCheckUrl()
    override fun setHealthCheckUrl(value: String) { healthCheckUrl = value }
    override fun getHealthCheckUrl(): String? = healthCheckUrl

    private var homePageUrlPath = super.getHomePageUrlPath()
    override fun setHomePageUrlPath(value: String) { homePageUrlPath = value }
    override fun getHomePageUrlPath(): String? = homePageUrlPath

    private var _namespace = super.getNamespace()
    override fun setNamespace(value: String) { _namespace = value }
    override fun getNamespace(): String? = _namespace

    private var  homePageUrl = super.getHomePageUrl()
    override fun setHomePageUrl(value: String) { homePageUrl = value }
    override fun getHomePageUrl(): String? = homePageUrl

    private var leaseExpirationDurationInSeconds = super.getLeaseExpirationDurationInSeconds()
    override fun setLeaseExpirationDurationInSeconds(value: Int) { leaseExpirationDurationInSeconds = value }
    override fun getLeaseExpirationDurationInSeconds(): Int = leaseExpirationDurationInSeconds

    private var instanceId = super.getInstanceId()
    override fun setInstanceId(value: String) { instanceId = value }
    override fun getInstanceId(): String? = instanceId

    private var defaultAddressResolutionOrder = super.getDefaultAddressResolutionOrder()
    override fun setDefaultAddressResolutionOrder(value: Array<String>) { defaultAddressResolutionOrder = value }
    override fun getDefaultAddressResolutionOrder(): Array<String>? = defaultAddressResolutionOrder

    private var appGroupName = super.getAppGroupName()
    override fun setAppGroupName(value: String) { appGroupName = value }
    override fun getAppGroupName(): String? = appGroupName

    private var virtualHostName = super.getVirtualHostName()
    override fun setVirtualHostName(value: String?) { virtualHostName = value }
    override fun getVirtualHostName(): String? = virtualHostName

    private var healthCheckUrlPath = super.getHealthCheckUrlPath()
    override fun setHealthCheckUrlPath(value: String) { healthCheckUrlPath = value }
    override fun getHealthCheckUrlPath(): String? = healthCheckUrlPath

    private var hostName:String? = null
    override fun getHostName(refresh: Boolean): String? {
        return hostName?: super.getHostName(refresh)
    }

    override fun setHostName(value: String?) {
        hostName = value
    }
}
