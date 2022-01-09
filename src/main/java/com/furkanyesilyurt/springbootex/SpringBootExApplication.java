package com.furkanyesilyurt.springbootex;

import com.furkanyesilyurt.springbootex.entity.Address;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootExApplication.class, args);

		Address address = new Address();

	}

}
