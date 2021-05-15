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
@Table(name = "ljekar")
public class Ljekar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy="ljekar" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Pacijent> pacijenti = new HashSet<Pacijent>();
	
	@OneToMany(mappedBy="ljekar" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Pregled> pregledi = new HashSet<Pregled>();
	
	@Column(name = "radni_kalendar", nullable = false)
	private String radniKalendar;
	
	@OneToOne
	@JoinColumn(name = "korisnik", referencedColumnName = "id", nullable = false)
	private Korisnik korisnik;
	
	public AdministratorKlinike getAdministratorKlinike() {
		return administratorKlinike;
	}

	public void setAdministratorKlinike(AdministratorKlinike administratorKlinike) {
		this.administratorKlinike = administratorKlinike;
	}

	@OneToOne
	@JoinColumn(name = "administratorKlinike", referencedColumnName = "id", nullable = false)
	private AdministratorKlinike administratorKlinike;
	
	//terapije != pregled ? 
	//private Set<String> terapije; 
	
	//profil korisnika ? 
	
	
	public Ljekar() {
		super();
	}
	
	public Ljekar(Long id, Set<Pacijent> pacijenti, Set<Pregled> pregledi, String radniKalendar) {
		super();
		this.id = id;
		this.pacijenti = pacijenti;
		this.pregledi = pregledi;
		this.radniKalendar = radniKalendar;
	}
	
	public Set<Pacijent> getPacijenti() {
		return pacijenti;
	}
	
	public void setPacijenti(Set<Pacijent> pacijenti) {
		this.pacijenti = pacijenti;
	}

	public Set<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(Set<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public String getRadniKalendar() {
		return radniKalendar;
	}

	public void setRadniKalendar(String radniKalendar) {
		this.radniKalendar = radniKalendar;
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

}
