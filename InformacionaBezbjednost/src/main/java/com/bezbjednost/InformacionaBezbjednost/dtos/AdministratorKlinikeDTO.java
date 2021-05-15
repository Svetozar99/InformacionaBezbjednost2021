package com.bezbjednost.InformacionaBezbjednost.dtos;

import com.bezbjednost.InformacionaBezbjednost.model.AdministratorKlinike;

public class AdministratorKlinikeDTO {

	private KorisnikDTO korisnikDTO;
	private AdministratorKlinickogCentraDTO administratorKlinickogCentraDTO;
	private Long id; 
	private String lozinka;
	private String ime; 
	private String prezime; 
	
	public AdministratorKlinikeDTO() {
		super();
	}
	
	public AdministratorKlinikeDTO(AdministratorKlinike dto) {
		this.id = dto.getId(); 
		this.lozinka = dto.getKorisnik().getLozinka(); 
		this.ime = dto.getKorisnik().getIme(); 
		this.prezime = dto.getKorisnik().getPrezime(); 
		this.korisnikDTO = new KorisnikDTO(dto.getKorisnik());
		this.administratorKlinickogCentraDTO = new AdministratorKlinickogCentraDTO(dto.getAdministratorKlinickogCentra());
	}

	public KorisnikDTO getKorisnikDTO() {
		return korisnikDTO;
	}

	public void setKorisnikDTO(KorisnikDTO korisnikDTO) {
		this.korisnikDTO = korisnikDTO;
	}

	public AdministratorKlinickogCentraDTO getAdministratorKlinickogCentraDTO() {
		return administratorKlinickogCentraDTO;
	}

	public void setAdministratorKlinickogCentraDTO(AdministratorKlinickogCentraDTO administratorKlinickogCentraDTO) {
		this.administratorKlinickogCentraDTO = administratorKlinickogCentraDTO;
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
}
