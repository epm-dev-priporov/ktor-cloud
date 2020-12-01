import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.3.61" apply false
    `maven-publish`
}

val ktorVersion: String by project
val _version = "1.0.0"
val groupValue: String = "net.devpriporov"

group = groupValue
version = _version

val Project.sourceSets: SourceSetContainer get() =
    (this as ExtensionAware).extensions.getByName("sourceSets") as SourceSetContainer

subprojects {
    apply {
        plugin("kotlin")
        plugin("org.gradle.maven-publish")
    }

    group = groupValue
    version = _version

    repositories {
        mavenCentral()
        jcenter()
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    dependencies {
        fun implementation(dependencyNotation: Any) = this.add("implementation", dependencyNotation)

        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))
        implementation("io.ktor:ktor-server-core:$ktorVersion")
    }


    val sourcesJar by tasks.registering(Jar::class) {
        archiveClassifier.set("sources")
    }

    publishing {
        publications {

            create<MavenPublication>("maven") {
                from(components["java"])
                artifact(sourcesJar.get())

                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
            }
        }
    }
}
