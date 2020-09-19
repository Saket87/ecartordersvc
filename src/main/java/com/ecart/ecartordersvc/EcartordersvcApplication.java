package com.ecart.ecartordersvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class EcartordersvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcartordersvcApplication.class, args);
	}

}
