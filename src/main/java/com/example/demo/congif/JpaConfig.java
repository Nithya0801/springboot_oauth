package com.example.demo.congif;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class JpaConfig {
	
	@Autowired
	private Environment env;
	    
	    @Bean
	    public DataSource dataSource() {
//	        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	        
//	        dataSource.setDriverClassName(dbDriverClassName);
//	        dataSource.setUrl(datasourceUrl);
//	        dataSource.setUsername(dbUsername);
//	        dataSource.setPassword(dbPassword);
//	        
//	        return dataSource;
	    	
	    	
	    	 final DriverManagerDataSource dataSource = new DriverManagerDataSource();        
	         dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	         dataSource.setUrl(env.getProperty("spring.datasource.url"));
	         dataSource.setUsername(env.getProperty("spring.datasource.username"));
	         dataSource.setPassword(env.getProperty("spring.datasource.password"));
	         return dataSource;
	    }
	    
	    @Bean
	    public TokenStore tokenStore() {
	        return new JdbcTokenStore(dataSource());
	    }
	    
	    @Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
			defaultTokenServices.setTokenStore(tokenStore());
			defaultTokenServices.setSupportRefreshToken(true);
			return defaultTokenServices;
		}
	}
