<h1 align="center">Tamable Foxes</h1>
<p align="center">A Paper plugin that lets you tame foxes — they sit, follow, sleep with you, and defend their owner.</p>

> ⚠️ Don't `/reload` the server with this plugin installed — you may lose foxes. Restart instead.

If you hit any errors, [open an issue](https://github.com/bybrooklyn/TamableFoxes/issues/new).

Have you ever wanted to tame foxes? Now you can — **feed a wild fox chicken to tame it** (33% chance per feed), and use **sweet berries to breed** them.

## Requirements

- **Paper** (or a Paper fork) for **Minecraft 26.1.2**
- **Java 25+**

This build targets 26.1.2 only. It is compiled Mojang-mapped against Paper via
[paperweight](https://github.com/PaperMC/paperweight) and ships marked
`paperweight-mappings-namespace: mojang`, so Paper loads it without remapping.
It will **not** run on Spigot/CraftBukkit or on other Minecraft versions.

## Installation

1. Grab `TamableFoxes-v<version>.jar` from the [Releases](https://github.com/bybrooklyn/TamableFoxes/releases) page
   (or download the `TamableFoxes` artifact from a [build run](https://github.com/bybrooklyn/TamableFoxes/actions)).
2. Drop it into your server's `plugins/` folder.
3. Restart the server.

Default config files: [`config.yml`](Plugin/src/main/resources/config.yml) ·
[`language.yml`](Plugin/src/main/resources/language.yml).

## Features

- 33% chance to tame (feed chicken); breeding with sweet berries
- Wild foxes pick berries from bushes and leap at targets
- Tamed foxes follow their owner and sleep when the owner sleeps
- Sneak + right-click to make a fox sit; sneak + right-click empty-handed to make it sleep
- Sneak + right-click lets a fox hold items
- A fox holding a totem of undying will consume it and be reborn
- Foxes attack their owner's target, and whatever attacks their owner
- Foxes attack chickens and rabbits
- Red and snow foxes, spawned naturally in the same biomes as vanilla foxes
- Death message when a tamed fox dies
- Fully translatable via `language.yml`; individual messages can be set to `disabled`
  (`taming-tamed-message`, `taming-asking-for-name-message`, `taming-chosen-name-perfect`, `fox-doesnt-trust`)
- `/givefox` to hand a fox to another player

## Commands

| Command | Alias | Description |
| --- | --- | --- |
| `/spawntamablefox [red\|snow]` | `/stf` | Spawn a tamable fox where you're standing (defaults to red). |
| `/tamablefoxes reload` | `/tamablefox` | Reload the plugin config. |
| `/givefox [player]` | — | Give one of your foxes to another player. |

## Permissions

| Permission | Description | Default |
| --- | --- | --- |
| `tamablefoxes.spawn` | Spawn tamable foxes. | op |
| `tamablefoxes.tame` | Tame a fox. | everyone |
| `tamablefoxes.tame.unlimited` | Bypass the per-player tame limit. | op |
| `tamablefoxes.tame.anywhere` | Bypass the banned-worlds list in `config.yml`. | op |
| `tamablefoxes.reload` | Reload the plugin config. | op |
| `tamablefoxes.givefox.give` | Give your foxes to other players. | everyone |
| `tamablefoxes.givefox.give.others` | Give *another* player's fox to someone. | op |
| `tamablefoxes.givefox.receive` | Receive foxes from other players. | everyone |

## Building

Requires **JDK 25+** and **Maven**; Gradle comes from the bundled wrapper.

```sh
./build.sh
```

The output jar is written to `Plugin/target/TamableFoxes-v<version>.jar` (and copied to `run/plugins/`).

Under the hood the build spans two tools (see [`build.sh`](build.sh)):

1. `mvn install` — install the parent POM and the `Utility` module to the local repo.
2. `26_1_R1/gradlew publishToMavenLocal` — build the Mojang-mapped NMS module with
   paperweight-userdev against the Paper 26.1.2 dev bundle.
3. `mvn -pl Plugin package` — shade everything into the final plugin jar and stamp
   the Mojang mappings namespace.

CI runs the same flow: [`build.yml`](.github/workflows/build.yml) on every push/PR,
and [`release.yml`](.github/workflows/release.yml) publishes a release with the jar.

## Metrics

![metrics](https://bstats.org/signatures/bukkit/TamableFoxes.svg)

Tamable Foxes collects anonymous server statistics through [bStats](https://bstats.org).
You can opt out in `plugins/bStats/config.yml`.
