plugins {
    `java-library`
    `maven-publish`
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.21"
}

group = "net.seanomik"
version = "2.3.2-FOX"

// MC 26.1.2 targets Java 25. We compile with --release 25 using whatever JDK runs Gradle
// (Java 26 locally) rather than a strict toolchain, to avoid requiring an exact JDK 25 install.
java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 25
}

repositories {
    mavenLocal() // tamablefoxes-util, installed by the Maven build
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.codemc.io/repository/maven-public/") // anvilgui
    maven("https://repo.codemc.io/repository/maven-snapshots/") // anvilgui snapshots
}

dependencies {
    // Mojang-mapped Paper 26.1.2 (net.minecraft.* + unversioned org.bukkit.craftbukkit.*)
    paperweight.paperDevBundle("26.1.2.build.69-stable")

    // The dev bundle lists net.kyori:adventure-text-serializer-ansi with an empty version
    // (a runtime-provided console lib). Supply the version via the adventure BOM that Paper
    // 26.1.2 uses (4.26.1) so the compile classpath resolves deterministically.
    compileOnly(platform("net.kyori:adventure-bom:4.26.1"))

    // Shared abstraction (NMSInterface, Config, etc.) — shaded by the Plugin module, compile-only here
    compileOnly("net.seanomik:tamablefoxes-util:2.3.2-FOX")
    compileOnly("net.wesjd:anvilgui:1.10.4-SNAPSHOT")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2") // javax.annotation.Nullable
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "tamablefoxes_v26_1_R1"
            // Publish the Mojang-mapped compiled classes for the Maven Plugin module to shade.
            artifact(tasks.jar)
        }
    }
}
