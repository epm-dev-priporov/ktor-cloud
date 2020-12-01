val ktorVersion: String by project

repositories {
    mavenLocal()
}

project.tasks.publishToMavenLocal{
    enabled = false
}
project.tasks.publishToMavenLocal{
    enabled = false
}
project.tasks.publishMavenPublicationToMavenLocal{
    enabled = false
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")

    implementation("net.devpriporov:ktor-eureka-client:1.0.0")

    implementation("org.kodein.di:kodein-di-framework-ktor-server-jvm:7.0.0")
    implementation("org.kodein.di:kodein-di-framework-ktor-server-controller-jvm:7.0.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

