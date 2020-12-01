rootProject.name = "ktor-cloud"

include("ktor-eureka-client")

include(":ktor-eureka-client-sample")
project(":ktor-eureka-client-sample").projectDir = File(rootDir,"samples/ktor-eureka-client-sample")
