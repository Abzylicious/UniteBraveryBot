import java.util.Properties

group = "me.abzylicious"
version = "1.1.0"
description = "A Discord bot heavily inspired by Ultimate Bravery to spice up your Pokemon Unite experience."

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("me.jakejmattson:DiscordKt:0.23.4")
    implementation("org.jsoup:jsoup:1.15.3")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"

        Properties().apply {
            setProperty("name", project.name)
            setProperty("description", project.description)
            setProperty("version", version.toString())
            setProperty("url", "https://github.com/Abzylicious/UniteBraveryBot")

            store(file("src/main/resources/bot.properties").outputStream(), null)
        }
    }

    shadowJar {
        archiveFileName.set("UniteBraveryBot.jar")
        manifest {
            attributes("Main-Class" to "me.abzylicious.unitebraverybot.MainKt")
        }
    }
}
