import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.3.61" apply false
    id("com.jfrog.bintray") version "1.8.4" apply false
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
        plugin("com.jfrog.bintray")
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

            register("mavenJava", MavenPublication::class) {
                from(components["java"])
                artifact(sourcesJar.get())

                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
            }
        }
    }

    fun bintray(configure: com.jfrog.bintray.gradle.BintrayExtension.() -> Unit) = (this as ExtensionAware).extensions.configure("bintray", configure)

    bintray {
        user = System.getenv("BINTRAY_USER")
        key = System.getenv("BINTRAY_KEY")
        setPublications("mavenJava")

        pkg(closureOf<com.jfrog.bintray.gradle.BintrayExtension.PackageConfig> {
            repo = "net.devpriporov"
            name = project.name
            vcsUrl = "https://github.com/epm-dev-priporov/ktor-cloud"
            setLicenses("Apache-2.0")
        })
    }
}

