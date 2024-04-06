package com.project.shopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ImportAutoConfiguration(AopAutoConfiguration.class)
//@SpringBootApplication(exclude = KafkaAutoConfiguration.class), disable in "application.yml"
public class ShopappApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopappApplication.class, args);
	}

}
/*
docker start zookeeper-01
docker start zookeeper-02
docker start zookeeper-03

docker restart kafka-broker-01
* */