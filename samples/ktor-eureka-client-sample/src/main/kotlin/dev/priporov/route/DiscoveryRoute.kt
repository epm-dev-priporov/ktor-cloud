package dev.priporov.route

import com.netflix.discovery.DiscoveryClient
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

class DiscoveryRoute(app: Application) : RoutManager(app) {

    private val discoveryClient by di.instance<DiscoveryClient>()

    override fun Route.getRoutes() {

        get("/routes") {
            val registeredApplications = discoveryClient.applications.registeredApplications

            call.respond(registeredApplications)
        }
    }

}
