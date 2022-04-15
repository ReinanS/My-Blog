package edu.com.pweb.newsblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class NewsblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsblogApplication.class, args);
	}

}
