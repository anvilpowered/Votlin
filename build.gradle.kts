plugins {
    id("com.github.johnrengelman.shadow") version "5.1.0"
    kotlin("jvm") version "1.3.40"
    kotlin("kapt") version "1.3.40"
}

val velocityVersion: String by project
val kotlinVersion: String by project
val pluginGroup: String by project
val pluginVersion: String by project

group = pluginGroup
version = pluginVersion

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    maven {
        url = uri("https://repo.velocitypowered.com/snapshots/")
    }
}

dependencies {
    val velocity = create("com.velocitypowered:velocity-api:$velocityVersion")
    api(velocity)
    kapt(velocity)
    val stdlib = create(kotlin("stdlib-jdk8"))
    api(stdlib)
    shadow(stdlib)
    val reflect = create(kotlin("reflect"))
    api(reflect)
    shadow(reflect)
    val coroutines = create("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.3.0-M2")
    api(coroutines)
    shadow(coroutines)
    val serialization = create("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")
    api(serialization)
    shadow(serialization)
}

tasks.shadowJar {
    archiveBaseName.set("${project.name}-$velocityVersion-$kotlinVersion")
    configurations = listOf(project.configurations.shadow.get())
    archiveClassifier.set("")
}

tasks.jar {
    enabled = false
}

tasks.build {
    dependsOn(tasks.shadowJar.get())
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    includeCompileClasspath = false
}

artifacts {
    archives(tasks.shadowJar.get())
}