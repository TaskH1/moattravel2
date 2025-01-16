package com.example.moattravel2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
					//URL permmitted for all users
					.requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/", "/signup/**", "/houses").permitAll()
					//URL permmitted for only admin users
					.requestMatchers("/admin/**").hasRole("ADMIN")
					//any other URL needs to be logged in
					.anyRequest().authenticated()
			)
			.formLogin((form) -> form
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/?loggedIn")
					.failureUrl("/login?error")
					.permitAll()	
			)
			.logout((logout) -> logout
					.logoutSuccessUrl("/?loggedOut")
					.permitAll()
			);
		return http.build();	
	}
	
	// Returned value will be registered to DI container by @Bean 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
