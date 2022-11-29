plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:20.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

    implementation("org.springframework.boot:spring-boot-starter-web:2.7.5")
    implementation("com.google.code.gson:gson:2.10")

    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.7.2")

    implementation("org.springframework.boot:spring-boot-devtools:2.7.0")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}