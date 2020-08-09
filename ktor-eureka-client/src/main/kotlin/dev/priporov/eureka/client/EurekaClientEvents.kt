package dev.priporov.eureka.client

import com.netflix.discovery.DiscoveryClient
import io.ktor.application.EventDefinition

val EurekaClientConnected = EventDefinition<DiscoveryClient>()
val EurekaClientClosed = EventDefinition<DiscoveryClient>()
