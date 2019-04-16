package com.example.demo;

import org.springframework.boot.SpringApplication;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringoauthtrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringoauthtrialApplication.class, args);
		
		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("123"));
		
		  String data=new Scanner(System.in).next();
	        System.out.println(data.matches("([a-zA-Z]+[0-9@\\$#]){3,5}"));
		
	}
	
//	@Configuration
//	protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//		@Override
//		public void init(AuthenticationManagerBuilder auth) throws Exception {
//			auth.inMemoryAuthentication().withUser("javainuse-user").password("javainuse-pass").roles("USER");
//		}
//
//	}

}
