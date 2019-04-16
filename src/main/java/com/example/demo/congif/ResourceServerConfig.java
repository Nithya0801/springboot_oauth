package com.example.demo.congif;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
	
//		http
//		 .authorizeRequests (). antMatchers ("/oauth/token", "/oauth/authorize**", "/publishes","/"). permitAll () 
//		  .and (). requestMatchers (). antMatchers ("/ private") // Deny access to "/ private"
//		 .and (). authorizeRequests ()
//		 .antMatchers ("/private"). access ("hasRole ('USER')") 
//		 .and (). requestMatchers (). antMatchers ("/ admin") // Deny access to "/ admin"
//		 .and (). authorizeRequests ()
//		 .antMatchers ("/admin"). access ("hasRole ('ADMIN')");
		
		
		http.authorizeRequests()
		.antMatchers("/oauth/token").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/private/**").authenticated()
		.and().csrf().disable();
		
	}
	
	
}
