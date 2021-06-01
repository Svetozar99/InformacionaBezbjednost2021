package com.bezbjednost.InformacionaBezbjednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezbjednost.InformacionaBezbjednost.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	Korisnik findByKorisnickoIme(String korisnickoIme);
}
