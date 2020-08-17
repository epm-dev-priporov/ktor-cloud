package dev.priporov.eureka.client.config

import com.netflix.discovery.EurekaClientConfig
import dev.priporov.eureka.client.config.client.KtorClientConfig
import dev.priporov.eureka.client.config.instance.KtorEurekaInstanceConfig
import dev.priporov.eureka.client.config.instance.KtorInstanceConfig

class EurekaConfig :

    EurekaClientConfig by KtorClientConfig(),
    KtorEurekaInstanceConfig by KtorInstanceConfig() {

}
