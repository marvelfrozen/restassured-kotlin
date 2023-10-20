plugins {
    kotlin("jvm") version "1.8.10"
}

repositories { mavenCentral() }

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")

    implementation("io.rest-assured:rest-assured:5.3.2")
}

tasks.withType(Test::class) {
    ignoreFailures = true
    useJUnitPlatform {}

    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}
