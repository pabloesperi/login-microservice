package com.login.microservice.controllers;

import java.security.Principal;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.microservice.models.Usr;

//import com.login.microservice.models.Usuario;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LoginController {

//	@PostMapping(value = "/loginn")
//	public void login(@RequestBody Principal principal ) {
//
//	}
	
    @RequestMapping("/login")
    public boolean login(@RequestBody Usr user) {
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
	    return user.getPassword().equals("1234");	    
    }
}
