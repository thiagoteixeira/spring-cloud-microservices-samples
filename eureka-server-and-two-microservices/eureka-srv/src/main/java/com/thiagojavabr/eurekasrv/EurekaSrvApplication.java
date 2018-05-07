package com.thiagojavabr.eurekasrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaSrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSrvApplication.class, args);
	}
}
