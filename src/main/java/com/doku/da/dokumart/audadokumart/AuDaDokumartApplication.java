package com.doku.da.dokumart.audadokumart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages = {"com.doku"})
@EnableJpaRepositories
public class AuDaDokumartApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuDaDokumartApplication.class, args);



	}

}
