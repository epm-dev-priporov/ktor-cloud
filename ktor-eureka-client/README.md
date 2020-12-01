# ktor-eureka-client
Ktor-eureka-client supposed to be the same as spring-eureka-client so that this
is compatible with spring-eureka-server and can be use together. 

# Install dependency

### gradle

    repositories {
        jcenter()
    }
    
    implementation "net.devpriporov:ktor-eureka-client:1.0.0"
    
## How to use
to apply the feature:

    install(EurekaClientFeature) {
      setEurekaServerServiceUrls(listOf("http://localhost:8761/eureka/"))
    }

The instance of __com.netflix.discovery.DiscoveryClient__ discovery client will be added to __io.ktor.application.Application__ as an extension field.

the example:
    
     embeddedServer(Netty, port = 8079) {
            val app: Application = this
    
            install(EurekaClientFeature) {
                appname = "ktor-client"
                setEurekaServerServiceUrls(listOf("http://localhost:8761/eureka/"))
            }
            
            app.discoveryClient
    }

Project gradle example can be found
[here](https://github.com/epm-dev-priporov/ktor-cloud/tree/master/samples/ktor-eureka-client-sample)
