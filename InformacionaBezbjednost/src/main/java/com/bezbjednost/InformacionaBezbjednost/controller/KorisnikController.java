package com.bezbjednost.InformacionaBezbjednost.controller;

import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezbjednost.InformacionaBezbjednost.model.Korisnik;
import com.bezbjednost.InformacionaBezbjednost.security.JwtGenerator;
import com.bezbjednost.InformacionaBezbjednost.security.model.JwtUser;
import com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl.KorisnikService;

@RestController
@RequestMapping(value = "/api")
public class KorisnikController {
	
	@Autowired
	KorisnikService userService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtGenerator jwtGenerator;
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String rawPassword){
		
		Korisnik user = userService.findByUsername(username);

		if (user == null || !encoder.matches(rawPassword, user.getLozinka())) { 
			return ResponseEntity
					.ok()
					.header("error", "true")
					.body("Pogresno korisnicko ime ili lozinka");
		}
		
		String random = String.format("%04d", new Random().nextInt(10000));
		
		JwtUser jwtUser = JwtUser.builder()
								 .id(user.getId())
								 .random(random)
								 .build();
		String jwt = jwtGenerator.generate(jwtUser);
		
		return ResponseEntity
				.ok()
				.header("error", "false")
				.header("roles", user.getKorisnikAuthorities()
						 			 .stream()
						 			 .flatMap(usersAuthority -> Stream.of(String.valueOf(usersAuthority.getAuthority().getUloga().toString()))).toArray(String[]::new))
				.body(jwt);

	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> register(@RequestParam(name = "username") String username 
			,@RequestParam(name = "password") String password
			,@RequestParam(name = "ime") String ime
			,@RequestParam(name = "prezime") String prezime){
		
		if (userService.findByUsername(username) != null) {
			
			return ResponseEntity
					.ok()
					.header("error", "true")
					.header("message", "Korisnik sa korisnickim imenom vec postoji")
					.build();
		}
		
		Korisnik k = new Korisnik();
		
		k.setIme(ime);
		k.setPrezime(prezime);
		k.setKorisnickoIme(username);
		k.setLozinka(encoder.encode(password));
		
		userService.save(k);
		
		return ResponseEntity
				.ok()
				.header("error", "false")
				.header("message", "Uspešno ste se registrovali.")
				.build();
	}
	
}
