@file:Suppress("unused")
package net.fabricmc.example

import net.fabricmc.loader.api.FabricLoader
import org.slf4j.LoggerFactory
import kotlin.io.path.absolutePathString

@JvmField
val MOD_ID = "modid"

@JvmField
val METADATA = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().metadata

@JvmField
val FOLDER = FabricLoader.getInstance().gameDir.resolve(MOD_ID).absolutePathString()

@JvmField
val LOGGER = LoggerFactory.getLogger(MOD_ID)

fun init() {
    println("Initializing")
}

fun postInit() {
    println("Posting initialization")
}

fun shutdown() {
    println("Shutting down")
}
