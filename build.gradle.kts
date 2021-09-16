import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("com.github.johnrengelman.shadow")
  kotlin("jvm")
  kotlin("kapt")
}

val kotlinVersion: String by project
val kotlinxCoroutinesVersion: String by project
val kotlinxSerializationVersion: String by project
val velocityVersion: String by project

group = "org.anvilpowered"
version = kotlinVersion

repositories {
  mavenCentral()
  maven("https://nexus.velocitypowered.com/repository/maven-public/")
}

dependencies {
  val velocity = create("com.velocitypowered:velocity-api:$velocityVersion")
  api(velocity)
  kapt(velocity)
  api(kotlin("stdlib-jdk8"))
  api(kotlin("reflect"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinxSerializationVersion")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:$kotlinxSerializationVersion")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
}
tasks {
  withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
  }
  withType<JavaCompile> {
    options.encoding = "UTF-8"
    sourceCompatibility = "11"
    targetCompatibility = "11"
  }
  jar {
    enabled = false
  }
  build {
    dependsOn(shadowJar)
  }
  shadowJar {
    archiveFileName.set("Votlin-${project.version}.jar")
  }
}

kapt {
  includeCompileClasspath = false
}
