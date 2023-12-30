plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization") version "1.7.0"
    id("maven-publish")
}

repositories {
    mavenCentral()
    google()
    maven("https://maven.kr328.app/releases")
    maven("https://jitpack.io")
}

val coroutine = "1.6.3"
val coreKtx = "1.8.0"
val serialization = "1.3.3"

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.0")
  implementation("androidx.appcompat:appcompat:1.4.1")
  implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.core:core-ktx:$coreKtx")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization")
}

android {
    ndkVersion = "23.0.7599858"

    compileSdkVersion(31)

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.findByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

publishing {
  publications {
    register<MavenPublication>("release") {
      groupId = "com.github.codemenworld"
      artifactId = "react-native-clash-hideapi"
      version = "1.0.0"

      afterEvaluate {
        from(components["release"])
      }
    }
  }
}