package com.bezbjednost.InformacionaBezbjednost.dtos;

import com.bezbjednost.InformacionaBezbjednost.model.EUloga;
import com.bezbjednost.InformacionaBezbjednost.model.Korisnik;

public class KorisnikDTO {
	
	private Long id; 
	private String lozinka;
	private String ime; 
	private String prezime; 
	private EUloga uloga;
	
	public KorisnikDTO(Korisnik korisnik) {
		this.id = korisnik.getId(); 
		this.lozinka = korisnik.getLozinka(); 
		this.ime = korisnik.getIme(); 
		this.prezime = korisnik.getPrezime(); 
		this.uloga = korisnik.getUloga(); 
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public EUloga getUloga() {
		return uloga;
	}
	public void setUloga(EUloga uloga) {
		this.uloga = uloga;
	}
	
}
