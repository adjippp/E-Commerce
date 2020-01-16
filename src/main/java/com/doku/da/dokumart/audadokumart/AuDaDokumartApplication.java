package com.doku.da.dokumart.audadokumart;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication (scanBasePackages = {"com.doku"})
@ComponentScan("com.doku")
@EnableJpaRepositories
public class AuDaDokumartApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuDaDokumartApplication.class, args);



	}

	@Bean
	public DozerBeanMapper dozerBeanMapper(){
		return new DozerBeanMapper();
	}

}
