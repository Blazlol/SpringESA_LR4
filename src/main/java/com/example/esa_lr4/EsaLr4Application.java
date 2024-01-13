package com.example.esa_lr4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class EsaLr4Application {

	public static void main(String[] args) {
		SpringApplication.run(EsaLr4Application.class, args);
	}

}
