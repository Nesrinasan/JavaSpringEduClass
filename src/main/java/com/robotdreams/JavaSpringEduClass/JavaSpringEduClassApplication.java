package com.robotdreams.JavaSpringEduClass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JavaSpringEduClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringEduClassApplication.class, args);
	}

}
