package com.bezbjednost.InformacionaBezbjednost.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "administrator_klinike")
public class AdministratorKlinike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "korisnik", referencedColumnName = "id", nullable = false)
	private Korisnik korisnik;
	
	@OneToMany(mappedBy="administratorKlinike" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Pregled> pregledi = new HashSet<Pregled>();
	
	@OneToMany(mappedBy="administratorKlinike" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Ljekar> ljekari = new HashSet<Ljekar>();
	
	@OneToOne
	@JoinColumn(name = "administratorKlinickogCentra", referencedColumnName = "id", nullable = false)
	private AdministratorKlinickogCentra administratorKlinickogCentra;
	
	//dodati objekte za kliniku i cjenovnik
	@Column(name = "klinika", nullable = false)
	private String klinika;
	
	@Column(name = "cjenovnik", nullable = false)
	private String cjenovnik;
	
	public AdministratorKlinike() {
		super();
	}
	
	public AdministratorKlinike(Long id, Korisnik korisnik, Set<Ljekar> ljekari, String klinika, String cjenovnik) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.ljekari = ljekari;
		this.klinika = klinika;
		this.cjenovnik = cjenovnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Set<Ljekar> getLjekari() {
		return ljekari;
	}

	public void setLjekari(Set<Ljekar> ljekari) {
		this.ljekari = ljekari;
	}

	public String getKlinika() {
		return klinika;
	}

	public void setKlinika(String klinika) {
		this.klinika = klinika;
	}

	public String getCjenovnik() {
		return cjenovnik;
	}

	public void setCjenovnik(String cjenovnik) {
		this.cjenovnik = cjenovnik;
	}
}
