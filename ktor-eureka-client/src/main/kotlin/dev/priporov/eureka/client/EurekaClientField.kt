package dev.priporov.eureka.client

import com.netflix.discovery.DiscoveryClient
import io.ktor.application.Application
import io.ktor.util.AttributeKey

internal val eurekaDiscoveryClientKey = AttributeKey<DiscoveryClient>("EurekaDiscoveryClient")

val Application.discoveryClient: DiscoveryClient
    get() = checkNotNull(attributes.getOrNull(eurekaDiscoveryClientKey)) {
        "EurekaDiscoveryClient not configured or still not initialized"
    }
