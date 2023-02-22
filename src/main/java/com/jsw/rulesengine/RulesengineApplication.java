package com.jsw.rulesengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jsw.rulesengine.*")
public class RulesengineApplication {

	public static void main(String[] args) {
		SpringApplication.run(RulesengineApplication.class, args);
	}

}
