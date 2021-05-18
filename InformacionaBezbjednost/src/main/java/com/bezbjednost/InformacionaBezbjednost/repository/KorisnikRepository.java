package com.bezbjednost.InformacionaBezbjednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezbjednost.InformacionaBezbjednost.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

}
