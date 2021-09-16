rootProject.name = "Votlin"

pluginManagement {
  plugins {
    val kotlinVersion: String by settings
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    val shadowVersion: String by settings
    id("com.github.johnrengelman.shadow") version shadowVersion
  }
}
