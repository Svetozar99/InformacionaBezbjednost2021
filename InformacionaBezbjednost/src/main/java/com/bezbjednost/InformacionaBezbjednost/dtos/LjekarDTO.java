package com.bezbjednost.InformacionaBezbjednost.dtos;

import com.bezbjednost.InformacionaBezbjednost.model.Ljekar;

public class LjekarDTO {
	
	private Long id; 
	private String ime; 
	private String prezime; 
	private String korisnickoIme;
	private AdministratorKlinikeDTO administratorKlinikeDTO; 
	private KorisnikDTO korisnikDTO;
	
	public LjekarDTO(Ljekar ljekar) {
		this.id = ljekar.getId(); 
		this.ime = ljekar.getIme(); 
		this.prezime = ljekar.getPrezime(); 
		this.korisnickoIme = ljekar.getKorisnickoIme(); 
		//this.administratorKlinikeDTO = new AdministratorKlinikeDTO(ljekar.getAdministratorKlinike());
		//this.korisnikDTO = new KorisnikDTO(ljekar.getKorisnik());
	}
	public LjekarDTO() {
		super();
	} 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public AdministratorKlinikeDTO getAdministratorKlinikeDTO() {
		return administratorKlinikeDTO;
	}
	public void setAdministratorKlinikeDTO(AdministratorKlinikeDTO administratorKlinikeDTO) {
		this.administratorKlinikeDTO = administratorKlinikeDTO;
	}
	public KorisnikDTO getKorisnikDTO() {
		return korisnikDTO;
	}
	public void setKorisnikDTO(KorisnikDTO korisnikDTO) {
		this.korisnikDTO = korisnikDTO;
	}

}
