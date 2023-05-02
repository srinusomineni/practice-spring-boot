package com.bis.sprintboot.practicespringboot;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// All URLs are protected
	// A login form is shown for unauthorized requests
	// CSRF disable
	// Frames

	// dothis
	// dothis
	// executeRequest

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

		http.httpBasic(withDefaults());

		http.csrf().disable(); // POST or PUT

		http.headers().frameOptions().disable();

		return http.build();
	}
}