package com.bezbjednost.InformacionaBezbjednost.dtos;

import com.bezbjednost.InformacionaBezbjednost.model.AdministratorKlinickogCentra;

public class AdministratorKlinickogCentraDTO {

	private Long id; 
	private String lozinka;
	private String ime; 
	private String prezime; 
	private KorisnikDTO korisnikDTO; 
	
	public AdministratorKlinickogCentraDTO() {
		super();
	}
	
	public AdministratorKlinickogCentraDTO(AdministratorKlinickogCentra dto) {
		this.id = dto.getId();
		this.lozinka = dto.getKorisnik().getLozinka();
		this.ime = dto.getKorisnik().getIme();
		this.prezime = dto.getKorisnik().getPrezime(); 
		this.korisnikDTO = new KorisnikDTO(dto.getKorisnik());
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
	
	public KorisnikDTO getKorisnikDTO() {
		return korisnikDTO;
	}

	public void setKorisnikDTO(KorisnikDTO korisnikDTO) {
		this.korisnikDTO = korisnikDTO;
	}
}
