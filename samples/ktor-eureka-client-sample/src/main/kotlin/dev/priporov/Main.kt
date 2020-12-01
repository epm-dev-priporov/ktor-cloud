package dev.priporov

import com.fasterxml.jackson.databind.SerializationFeature
import dev.priporov.di.discoveryModule
import dev.priporov.eureka.client.EurekaClientFeature
import dev.priporov.route.DiscoveryRoute
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.kodein.di.ktor.controller.controller
import org.kodein.di.ktor.di
import java.lang.Compiler.enable


fun main(args: Array<String>) {

    embeddedServer(Netty, port = 8079) {
        val app = this

        install(ContentNegotiation) {
            jackson {
                enable(SerializationFeature.INDENT_OUTPUT)
            }
        }

        install(EurekaClientFeature) {
            healthCheckUrlPath = "/health_check"
            appname = "ktor-client"
            setEurekaServerServiceUrls(listOf("http://localhost:8761/eureka/"))
            enableRegisterWithEureka(true)
        }

        di {
            importOnce(discoveryModule(app))
        }

        routing {
            controller { DiscoveryRoute(app) }
            get("/health_check") {
                call.respondText("OK")
            }
        }

    }.start(true)

}
