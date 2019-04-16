package com.example.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class TokenController {

//	 @Resource(name = "tokenServices")
//	    ConsumerTokenServices tokenServices;
//
////	    @Resource(name = "tokenStore")
////	    TokenStore tokenStore;
//
//	    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token/revokeById/{tokenId}")
//	    @ResponseBody
//	    public void revokeToken(HttpServletRequest request, @PathVariable String tokenId) {
//	    	System.out.println("Revoking Token");
//	        tokenServices.revokeToken(tokenId);
//	    }
	    
	    
	    @Autowired
	    private TokenStore tokenStore;

	    @RequestMapping(value = "/oauth/token/revokeById/{tokenId}", method = RequestMethod.POST)
//	    @ResponseStatus(HttpStatus.OK)
	    public void logout(HttpServletRequest request) {
	    	
	    	System.out.println("------------------called-------------");
	        String authHeader = request.getHeader("Authorization");
	        if (authHeader != null) {
	            String tokenValue = authHeader.replace("Bearer", "").trim();
	            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
	            tokenStore.removeAccessToken(accessToken);
	        }
	    }
}
