plugins {
	java
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.freedomBanking"
version = "0.0.1-SNAPSHOT"
description = "api-gateway for freedomBanking"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2025.0.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation ("org.springframework.cloud:spring-cloud-starter-config")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.cloud:spring-cloud-starter-gateway")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation ("org.springframework.boot:spring-boot-starter-security")
	runtimeOnly ("io.micrometer:micrometer-registry-prometheus")
	implementation("io.jsonwebtoken:jjwt-api")
	runtimeOnly("io.jsonwebtoken:jjwt-impl")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson")
	implementation ("org.springframework.boot:spring-boot-starter-data-redis-reactive")
	implementation ("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
