@file:Suppress("unused")
package net.fabricmc.example

import net.fabricmc.loader.api.FabricLoader
import org.slf4j.LoggerFactory
import kotlin.io.path.absolutePathString

@JvmField
val MOD_ID = "modid"

@JvmField
val MOD_METADATA = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().metadata

@JvmField
val MOD_FOLDER = FabricLoader.getInstance().gameDir.resolve(MOD_ID).absolutePathString()

@JvmField
val MOD_LOGGER = LoggerFactory.getLogger(MOD_ID)

fun init() {
    println("Initialization")
}

fun postInit() {
    println("Post initialization")
}

fun shutdown() {
    println("Shutting down")
}
