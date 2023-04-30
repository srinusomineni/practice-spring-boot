package com.bis.sprintboot.practicespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.bis.sprintboot.**.service",
		"com.bis.sprintboot.**.web",
		"com.bis.springboot.**.repo"
		})
public class PracticeSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringBootApplication.class, args);
	}

}
