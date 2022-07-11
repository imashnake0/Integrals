import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
}

group = "com.imashnake"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    dependencies {
        implementation("org.jetbrains.lets-plot:lets-plot-common:2.4.0")
        implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:3.3.0")
        implementation("org.jetbrains.lets-plot:lets-plot-image-export:2.4.0")
    }
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}