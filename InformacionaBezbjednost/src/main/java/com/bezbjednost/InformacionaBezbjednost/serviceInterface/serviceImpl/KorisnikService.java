package com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezbjednost.InformacionaBezbjednost.model.Korisnik;
import com.bezbjednost.InformacionaBezbjednost.repository.KorisnikRepository;

@Service
public class KorisnikService {

	@Autowired
	KorisnikRepository korisnikRepository; 
	
	public Korisnik findOne(Long id) {
		return korisnikRepository.findById(id).orElse(null);
	}
	
	public Korisnik findByUsername(String username) {
		return korisnikRepository.findByKorisnickoIme(username);
	}
	
	public Korisnik save(Korisnik k){
		return korisnikRepository.save(k);
	}
	
	
}
