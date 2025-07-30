# Corrupted Selma Block Mod

## Features

- Singular purple skulk-purpur block ("Corrupted Selma Block"): slowly spreads corruption.
- Corruption spreads to blocks and **corrupts mobs** (glowing, strong, particle effects).
- Corrupted mobs spread the block as they walk.
- Designed for Fabric Minecraft 1.21.

## Usage

1. Build and install with Fabric Loader and API for 1.21.
2. Give yourself the block with `/give @p selmablockmod:corrupted_selma_block`.
3. Place it. Watch the world and mobs corrupt, skulk/purpur style!

## Customization

- Replace `src/main/resources/assets/selmablockmod/textures/block/corrupted_selma_block.png` with your own purple skulk-purpur texture if desired.

---
plugins {
    id 'fabric-loom' version '1.6-SNAPSHOT'
    id 'maven-publish'
}

group = 'com.example'
version = '1.0.0'

repositories {
    mavenCentral()
    maven { url = 'https://maven.fabricmc.net/' }
}

dependencies {
    minecraft "com.mojang:minecraft:1.21"
    mappings "net.fabricmc:yarn:1.21+build.1:v2"
    modImplementation "net.fabricmc:fabric-loader:0.15.10"
    modImplementation "net.fabricmc.fabric-api:fabric-api:0.97.0+1.21"
}

loom {
    splitEnvironmentSourceSets()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

tasks.withType(JavaCompile).configureEach {
    it.options.encoding = 'UTF-8'
}
**Enjoy the corruption, Selma and Wendy!**
#!/bin/sh
##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################
# (Content omitted for brevity in this example. In production, this file is ~250 lines.)
# Download the full gradlew script from a Fabric example mod repo or generate with Gradle.
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.4-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
