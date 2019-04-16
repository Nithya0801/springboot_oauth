package com.example.demo.congif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter{
//
//	 @Bean
//	    @Override
//	    public UserDetailsService userDetailsService () {
//	    UserDetails user = User.builder (). username ("user"). password ("secret").
//	    roles ("USER"). build ();
//	    UserDetails userAdmin = User.builder (). username ("admin"). password ("secret").
//	    roles ("ADMIN"). build ();	
//	        return new InMemoryUserDetailsManager (user, userAdmin);
//	    }
	
//	 @Autowired
//	    private AuthenticationManager authenticationManager;
	    @Autowired
	    private UserDetailsService customUserDetailsService;
	@Override
	@Bean(name="authenticationManager")
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	//Added Additionally
	@Bean(name="passwordEncoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().withUser("user").password("{noop}123").authorities("USER");
		
//		 auth.parentAuthenticationManager(authenticationManager)
//         .userDetailsService(customUserDetailsService);
		
		
		System.out.println("--------------calling JDBC Authen--------------------");
		auth.userDetailsService(customUserDetailsService)
		.passwordEncoder(passwordEncoder())
		.and()
		.authenticationProvider(authenticationProvider());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		
		
//		http.authorizeRequests()
//		//.antMatchers("/oauth/token").permitAll()
//		.antMatchers("/**").authenticated()
//		.and().csrf().disable();
		
		http.authorizeRequests()
		//.antMatchers("/oauth/token/*").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/private/**").authenticated();
		
	}
	
	//Added on 12/04
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
	
}
