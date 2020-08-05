package com.example.springPostgres.springPostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories

public class SpringPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPostgresqlApplication.class, args);
	}

}
