import com.jfrog.bintray.gradle.BintrayExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.tasks.bundling.Jar

plugins {
    base
    kotlin("jvm") version "1.3.61" apply false
    id("com.jfrog.bintray") version "1.8.4" apply false
    id("com.github.ben-manes.versions") version "0.27.0"
    `maven-publish`
}

val ktorVersion: String by project
val _version = "1.0.0"
val groupValue:String = "net.devpriporov"

group = groupValue
version = _version


val Project.sourceSets: SourceSetContainer get() =
    (this as ExtensionAware).extensions.getByName("sourceSets") as SourceSetContainer

subprojects {
    apply {
        plugin("kotlin")
        plugin("com.jfrog.bintray")
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
        from(sourceSets["main"].allSource)
    }

    fun bintray(configure: BintrayExtension.() -> Unit) = (this as ExtensionAware).extensions.configure("bintray", configure)

    val project = this
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
}
