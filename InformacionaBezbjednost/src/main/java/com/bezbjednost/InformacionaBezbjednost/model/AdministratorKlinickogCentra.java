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
@Table(name = "administrator_klinickog_centra")
public class AdministratorKlinickogCentra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "korisnik", referencedColumnName = "id", nullable = false)
	private Korisnik korisnik;
	
	//dodati listu klinika 
	@Column(name = "klinike", nullable = false)
	private String klinike;
	
	@OneToMany(mappedBy="administratorKlinickogCentra" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<AdministratorKlinike> administratoriKlinika = new HashSet<AdministratorKlinike>();

	@OneToMany(mappedBy="administratorKlinickogCentra" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Pacijent> pacijenti = new HashSet<Pacijent>();
	
	public void add(AdministratorKlinike adminKlinike) {
		if(adminKlinike.getAdministratorKlinickogCentra() != null)
			adminKlinike.getAdministratorKlinickogCentra().getAdministratoriKlinika().remove(adminKlinike);
		adminKlinike.setAdministratorKlinickogCentra(this);
		administratoriKlinika.add(adminKlinike);
	}
	
	public void remove(AdministratorKlinike adminKlinike) {
		adminKlinike.setAdministratorKlinickogCentra(null);
		administratoriKlinika.remove(adminKlinike);
	}
	
	//uraditi isto za pacijente 
	
	public AdministratorKlinickogCentra() {
		super();
	}

	public AdministratorKlinickogCentra(Long id, Korisnik korisnik, String klinike,
			Set<AdministratorKlinike> administratoriKlinika, Set<Pacijent> pacijenti) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.klinike = klinike;
		this.administratoriKlinika = administratoriKlinika;
		this.pacijenti = pacijenti;
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

	public String getKlinike() {
		return klinike;
	}

	public void setKlinike(String klinike) {
		this.klinike = klinike;
	}

	public Set<AdministratorKlinike> getAdministratoriKlinika() {
		return administratoriKlinika;
	}

	public void setAdministratoriKlinika(Set<AdministratorKlinike> administratoriKlinika) {
		this.administratoriKlinika = administratoriKlinika;
	}

	public Set<Pacijent> getPacijenti() {
		return pacijenti;
	}

	public void setPacijenti(Set<Pacijent> pacijenti) {
		this.pacijenti = pacijenti;
	}

}
