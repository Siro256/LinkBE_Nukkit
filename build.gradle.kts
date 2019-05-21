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
}

dependencies {
    implementation("cn.nukkit:nukkit:1.0-SNAPSHOT")
    testCompile("junit", "junit", "4.12")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}