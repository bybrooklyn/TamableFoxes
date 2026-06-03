#!/usr/bin/env bash
#
# Build the TamableFoxes plugin jar (MC 26.1.2, Paper, Mojang-mapped).
#
# The 26.1.2 NMS module (26_1_R1) is built with Gradle + paperweight-userdev and
# published to the local Maven repo; the Maven Plugin module then shades it.
#
# Requirements:
#   - JDK 25+ on PATH / JAVA_HOME (MC 26.1.2 targets Java 25)
#   - Maven on PATH (override with: MVN=/path/to/mvn ./build.sh)
#   - Gradle is provided by the bundled wrapper (26_1_R1/gradlew)
#
# Output: Plugin/target/TamableFoxes-v<version>.jar (also copied to run/plugins/)

set -euo pipefail
cd "$(dirname "$0")"

MVN="${MVN:-mvn}"

echo "==> [1/3] Installing parent POM + Utility to the local Maven repo"
"$MVN" -B -N install
"$MVN" -B -pl Utility install

echo "==> [2/3] Building Mojang-mapped 26.1.2 NMS module (paperweight)"
( cd 26_1_R1 && ./gradlew --no-daemon publishToMavenLocal )

echo "==> [3/3] Packaging shaded plugin jar"
"$MVN" -B -pl Plugin package

echo "==> Done:"
ls -1 Plugin/target/TamableFoxes-v*.jar
