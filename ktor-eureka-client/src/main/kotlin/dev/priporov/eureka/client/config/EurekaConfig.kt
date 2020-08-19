package dev.priporov.eureka.client.config

import dev.priporov.eureka.client.config.client.KtorClientConfig
import dev.priporov.eureka.client.config.client.KtorEurekaClientConfig
import dev.priporov.eureka.client.config.instance.KtorEurekaInstanceConfig
import dev.priporov.eureka.client.config.instance.KtorInstanceConfig

class EurekaConfig :

    KtorEurekaClientConfig by KtorClientConfig(),
    KtorEurekaInstanceConfig by KtorInstanceConfig() {

}
