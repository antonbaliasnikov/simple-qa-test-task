import org.jetbrains.kotlin.konan.properties.hasProperty

plugins {
    kotlin("jvm") version "1.5.31"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.8.2"
val cucumberVersion = "7.1.0"
val googleTruthVersion = "1.1.3"

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("org.junit.vintage:junit-vintage-engine:$junitVersion")

    testImplementation("com.google.truth:truth:$googleTruthVersion")

    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-jvm:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit:$cucumberVersion")
}

tasks.test {
    systemProperty("cucumber.options", System.getProperty("cucumber.options"))
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
        events("passed", "failed", "skipped")

        if (System.getProperties().hasProperty("logs-dir")) {
            val stdOut = StringBuilder()
            val stdErr = StringBuilder()

            logging.addStandardOutputListener { stdOut.append(it) }
            logging.addStandardErrorListener { stdErr.append(it)}
            doLast {
                mkdir("logs")
                project.file("${System.getProperty("logs-dir")}/stdout.log").writeText(stdOut.toString())
                project.file("${System.getProperty("logs-dir")}/stderr.log").writeText(stdErr.toString())
            }
        }
    }
}
