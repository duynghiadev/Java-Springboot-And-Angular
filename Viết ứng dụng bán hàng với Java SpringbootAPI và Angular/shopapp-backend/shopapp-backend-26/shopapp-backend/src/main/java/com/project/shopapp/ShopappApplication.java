package com.project.shopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ImportAutoConfiguration(AopAutoConfiguration.class)
public class ShopappApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopappApplication.class, args);
	}

}
