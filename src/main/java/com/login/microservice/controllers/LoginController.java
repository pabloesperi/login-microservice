package com.login.microservice.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.microservice.models.Usuario;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class LoginController {

	@PostMapping(value = "/login")
	public void login(@RequestBody Usuario user ) {
		Principal principal = (Principal) user;
	}
}
