plugins {
    id("java")
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "pl.paisley4.omsivehicleutils"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("com.ibm.icu:icu4j:77.1")
    implementation("com.ibm.icu:icu4j-charset:77.1")
    implementation("com.ibm.icu:icu4j-localespi:77.1")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("pl.paisley4.omsivehicleutils.Main")
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to application.mainClass)
    }
}