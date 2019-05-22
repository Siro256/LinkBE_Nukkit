import java.net.URI
plugins {
    java
}

group = "net.siro256yt.nukkitpl.linkbe"
version = "0.1.0-BETA"

project.sourceSets{
    getByName("main") { java.srcDir("src/main/java") }
    getByName("test") { java.srcDir("src/test/java") }
}

repositories {
    mavenCentral()
    maven { url = URI("https://repo.nukkitx.com/maven-snapshots") }
    maven {url = URI("https://mvnrepository.com/artifact/mysql/mysql-connector-java")}
}

val embed: Configuration by configurations.creating

dependencies {
    implementation("cn.nukkit:nukkit:1.0-SNAPSHOT")
    implementation("mysql:mysql-connector-java:8.0.16")
    testCompile("junit", "junit", "4.12")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.jar {
    val embedConfiguration = embed.copy()

    from(embedConfiguration.map { if (it.isDirectory) it else zipTree(it) })
}