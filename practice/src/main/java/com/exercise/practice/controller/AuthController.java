package com.exercise.practice.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.practice.config.JwtUtil;
import com.exercise.practice.dto.TokenDto;
import com.exercise.practice.exception.InvalidUsernameException;
import com.exercise.practice.model.User;
import com.exercise.practice.service.AuthService;
import com.exercise.practice.service.MyUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController 
{
	@Autowired
	private AuthService authService;
	
	@Autowired
	private MyUserService myUserService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/signup")
	public User signUp(@RequestBody User user) throws InvalidUsernameException//this exception will show the enduser that this username already exists
	{
		return authService.signUp(user);		
	}
	
	@PostMapping("/login")
	public UserDetails login(Principal principal)//we are redirecting the user logged in to their concerned dashboard according to their role
	{
		String username = principal.getName();
		return myUserService.loadUserByUsername(username);
	}
	
	@PostMapping("/token/generate")
	public TokenDto generatedToken(@RequestBody User user, TokenDto dto)
	{
		/*Step 1. Build authentication ref based on username,passord given*/
		Authentication auth = 
		new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
	
		authenticationManager.authenticate(auth);//This is the person who checks the credentials are correct or not
		
		/*Step 2: Generate the token since we know that credentials are correct */
		String token =  jwtUtil.generateToken(user.getUsername()); 
		dto.setToken(token);
		dto.setUsername(user.getUsername());
		dto.setExpiry(jwtUtil.extractExpiration(token).toString());
		return dto; //This dto gets the token,username and expiry timings
	}
	@GetMapping("/user/details")
	public UserDetails getUserDetails(Principal principal) 
	{
		String username = principal.getName();//this is for getting username
		return myUserService.loadUserByUsername(username);
	}
}
