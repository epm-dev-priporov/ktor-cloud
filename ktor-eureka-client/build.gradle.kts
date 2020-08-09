val ktorVersion: String by project

dependencies {
    api("com.netflix.eureka:eureka-client:1.9.2")

    implementation("com.netflix.archaius:archaius-core:0.7.7")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("javax.inject:javax.inject:1")
}
