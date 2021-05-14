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
@Table(name = "medicinska_sestra")
public class MedicinskaSestra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "korisnik", referencedColumnName = "id", nullable = false)
	private Korisnik korisnik;
	
	@OneToMany(mappedBy="medicinskaSestra" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Pacijent> pacijenti = new HashSet<Pacijent>();
	
	@Column(name = "radni_kalendar", nullable = false)
	private String radniKalendar;
	
	//profil korisnika 
	
	//stranica za ovjeravanje recepata ?? 
	
	public MedicinskaSestra() {
		super();
	}

	public MedicinskaSestra(Long id, Korisnik korisnik, Set<Pacijent> pacijenti, String radniKalendar) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.pacijenti = pacijenti;
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

	public Set<Pacijent> getPacijenti() {
		return pacijenti;
	}

	public void setPacijenti(Set<Pacijent> pacijenti) {
		this.pacijenti = pacijenti;
	}

	public String getRadniKalendar() {
		return radniKalendar;
	}

	public void setRadniKalendar(String radniKalendar) {
		this.radniKalendar = radniKalendar;
	}
}
