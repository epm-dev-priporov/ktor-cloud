# ktor-eureka-client
Ktor-eureka-client supposed to be the same as spring-eureka-client so that this
is compatible with spring-eureka-server and can be use together. 

# Install dependency

### gradle
    
    implementation "net.devpriporov:ktor-eureka-client:0.1-SNAPSHOT"
    
    
### maven

     

## How to use
to apply the feature:

    install(EurekaClientFeature) {
      setEurekaServerServiceUrls(listOf("http://localhost:8761/eureka/"))
    }

The instance of __com.netflix.discovery.DiscoveryClient__ discovery client will be added to __io.ktor.application.Application__ as an extension field.

the xample:
    
     embeddedServer(Netty, port = 8079) {
            val app: Application = this
    
            install(EurekaClientFeature) {
                appname = "ktor-client"
                setEurekaServerServiceUrls(listOf("http://localhost:8761/eureka/"))
            }
            
            app.discoveryClient
    }
