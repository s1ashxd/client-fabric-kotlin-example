# Fabric Kotlin Mod - Client-Side Example

## Setup

1. Create a new mod repository by pressing the "Use this template" button and clone the created repository.

2. Import build.gradle.kts file with IntelliJ IDEA

3. Edit build.gradle.kts and fabric.mod.json to suit your needs.
    * The "mixins" object can be removed from fabric.mod.json if you do not need to use mixins.
    * Please replace all occurrences of "modid" with your own mod ID - sometimes, a different string may also suffice.
4. Run!

## Mod lifecycle

The main file ExampleMod.kt has two stages of initialization and one stage of shutdown:
1. init() - Called by the Fabric engines as soon as Minecraft is ready to load a mod
   * At the time of the call, minecraft resources and clients may not be fully loaded
2. postInit() - Called in the setOverlay() method call interceptor in the MinecraftClient class constructor.
   * The interceptor is described in the MinecraftClientMixin.java mixin
   * At the time of the call, all minecraft resources and mods are already loaded
3. shutdown() - Called at the beginning of the call to the stop() method in the MinecraftClient class.
   * Implemented in MinecraftClientMixin.java mixin
   * Minecraft is already half finished

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
