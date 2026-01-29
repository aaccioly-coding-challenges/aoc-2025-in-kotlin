plugins {
    alias(libs.plugins.kotlin.jvm)
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.logging)
    runtimeOnly(libs.logback.classic)

    // Use junit BOM for consistent versions
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)

    testImplementation(libs.kotest.assertions.core)

}

tasks {
    wrapper {
        gradleVersion = "9.3.1"
    }

    // Use JUnit Platform for tests
    test {
        useJUnitPlatform()
    }
}
