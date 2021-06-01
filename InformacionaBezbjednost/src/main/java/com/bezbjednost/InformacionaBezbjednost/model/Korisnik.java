package com.bezbjednost.InformacionaBezbjednost.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="korisnik")
public class Korisnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "korisnicko_ime", nullable = false, unique = true)
	private String korisnickoIme;

	@Column(name = "lozinka", nullable = false)
	private String lozinka;

	@Column(name = "ime", nullable = false)
	private String ime;

	@Column(name = "prezime", nullable = false)
	private String prezime;
	
	@Column(name = "euloga", nullable = false)
	private EUloga uloga;
	
	@OneToMany(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<KorisnikAuthorithy> korisnikAuthorities = new ArrayList<KorisnikAuthorithy>();
	
	public Korisnik() {
		super();
	}
	
	public Korisnik(Long id, String korisnickoIme, String lozinka, String ime, String prezime, EUloga uloga) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.uloga = uloga;
	}
	
	

	public Korisnik(Long id, String korisnickoIme, String lozinka, String ime, String prezime, EUloga uloga,
			List<KorisnikAuthorithy> korisnikAuthorities) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.uloga = uloga;
		this.korisnikAuthorities = korisnikAuthorities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
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

	public List<KorisnikAuthorithy> getKorisnikAuthorities() {
		return korisnikAuthorities;
	}

	public void setKorisnikAuthorities(List<KorisnikAuthorithy> korisnikAuthorities) {
		this.korisnikAuthorities = korisnikAuthorities;
	}
	
}
