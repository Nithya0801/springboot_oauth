package com.example.demo.congif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

		@Autowired
	   private AuthenticationManager authenticationManager;
	   
		@Autowired
		PasswordEncoder passwordEncoder;
		
	   @Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			
		 clients .inMemory() .withClient("my-trusted-client")
		 .authorizedGrantTypes("client_credentials","password","refresh_token")
		 .scopes("read","write","trust") 
		 .secret(passwordEncoder.encode("secret"));
		  //.secret("{noop}secret");
		  
	}
	   
//	   @Override
//	    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//	        security.passwordEncoder(passwordEncoder);
//	    }
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
				
		endpoints
        .authenticationManager (authenticationManager);     
       
		
	}
	
	/*for logout*/
//	
//	@Bean
//	@Primary
//	public DefaultTokenServices tokenServices() {
//		final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//		defaultTokenServices.setTokenStore(tokenStore());
//		defaultTokenServices.setSupportRefreshToken(true);
//		return defaultTokenServices;
//	}
//
//	@Bean
//	public TokenStore tokenStore() {
//		return new InMemoryTokenStore();
//	}
}
