plugins {
    id("java")
}

group = "fr.vahelnir"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(files("server/HytaleServer.jar"))
}

tasks.register<JavaExec>("runServer") {
    dependsOn("build")
    workingDir = file("server")
    mainClass.set("com.hypixel.hytale.Main")
    classpath = files(
        "server/HytaleServer.jar",
        "build/libs/${project.name}-${project.version}.jar"
    )
    args = listOf("--assets", "Assets.zip")
    standardInput = System.`in`
}
