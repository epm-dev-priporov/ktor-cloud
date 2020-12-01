package dev.priporov.di

import com.netflix.discovery.DiscoveryClient
import dev.priporov.eureka.client.discoveryClient
import io.ktor.application.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val discoveryModule = { app: Application ->
    DI.Module("discoveryClient") {
        bind<DiscoveryClient>() with singleton { app.discoveryClient }
    }
}
