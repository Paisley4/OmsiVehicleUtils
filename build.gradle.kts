plugins {
    id("java")
}

group = "pl.paisley4.omsivehicleutils"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
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