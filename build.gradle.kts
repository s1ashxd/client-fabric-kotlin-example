plugins {
    kotlin("jvm") version "1.8.20"
    id("fabric-loom") version "1.1-SNAPSHOT"
}

group = property("maven_group")!!
version = property("mod_version")!!

repositories {
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:1.19.4+build.2:v2")
    modImplementation("net.fabricmc:fabric-loader:0.14.21")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.9.3+kotlin.1.8.20")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.83.0+1.19.4")
}

tasks {
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }
    jar {
        from("LICENSE")
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}

java {
    withSourcesJar()
}
