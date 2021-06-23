package com.jt.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JtPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtPaymentServiceApplication.class, args);
	}

}
