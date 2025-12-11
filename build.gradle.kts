plugins {
    alias(libs.plugins.kotlin.jvm)
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.logging)
    runtimeOnly(libs.logback.classic)
}

tasks {
    wrapper {
        gradleVersion = "9.2.1"
    }
}
