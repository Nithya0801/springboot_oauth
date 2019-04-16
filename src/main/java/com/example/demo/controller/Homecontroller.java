package com.example.demo.controller;


import java.util.Optional;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;




@RestController
@CrossOrigin(value = "http://localhost:8080")
public class Homecontroller {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String home()
	{
		return "Home";
	}
	
	@GetMapping("/private")
	public String privateArea()
	{
		return "private";
	}
	
	
	
	 @GetMapping ("/publishes")
	   public String publico () {
	    return "Public Page";
	   }
	  
	   @GetMapping ("/admin")
	   public String admin () {
	     return "Administrator Page";
	   }
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ResponseEntity<User> load(@RequestBody User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return ResponseEntity.status(HttpStatus.OK).body(userRepo.save(user));
	}
	
	@GetMapping("/userCheck/{username}")
	public ResponseEntity userCheck(@PathVariable String username)
	{
		System.out.println(userRepo.findById(username));
		Optional<User> op=userRepo.findById(username);
		System.out.println(op.isPresent());
		if(!op.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(true);
		else
			return ResponseEntity.status(HttpStatus.CONFLICT).body(false);
	}
	
	
}
