package com.compasso.springboot.msnotification;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MsnotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsnotificationApplication.class, args);
	}

}
