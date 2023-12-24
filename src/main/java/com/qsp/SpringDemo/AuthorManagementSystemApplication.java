package com.qsp.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorManagementSystemApplication.class, args);
	}

	
	//Stereotype Annotation:-
	//1)@Controller
	//2)@Service
	//3)@Repository
	//4)@Configuration   
	//All these configuration have its own functionality as well as the @Component capability by default.
}
