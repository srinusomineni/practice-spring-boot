package com.bis.sprintboot.practicespringboot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {
  
//	    @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests()
//                    .antMatchers("/h2/**").permitAll().antMatchers("/**").hasAuthority("DEVELOPER").and()
//                    .authorizeHttpRequests()
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .httpBasic(withDefaults());
//            http.csrf(csrf -> csrf.disable());
//            http.cors();
//
//	    return http.build();
//	    }
//	    
//	    
//	    @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder authentication)
//	            throws Exception
//	    {
//	        authentication.inMemoryAuthentication()
//	                .withUser("admin")
//	                .password(passwordEncoder().encode("nimda"))
//	                .authorities("ROLE_USER");
//	    }
//
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
	}