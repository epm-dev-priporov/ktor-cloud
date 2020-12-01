package dev.priporov.route

import io.ktor.application.Application
import io.ktor.routing.Route
import org.kodein.di.ktor.controller.DIController
import org.kodein.di.ktor.di

abstract class RoutManager(val app: Application) : DIController {

    override val di by di { app }

    abstract override fun Route.getRoutes()

}
