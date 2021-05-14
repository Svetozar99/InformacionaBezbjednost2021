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
@Table(name = "pacijent")
public class Pacijent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "korisnik", referencedColumnName = "id", nullable = false)
	private Korisnik korisnik;
	



	@OneToOne
	@JoinColumn(name = "medicinskaSestra", referencedColumnName = "id", nullable = false)
	private MedicinskaSestra medicinskaSestra;
	
	@OneToOne
	@JoinColumn(name = "ljekar", referencedColumnName = "id", nullable = false)
	private Ljekar ljekar;
	
	@OneToOne
	@JoinColumn(name = "administratorKlinickogCentra", referencedColumnName = "id", nullable = false)
	private AdministratorKlinickogCentra administratorKlinickogCentra;
	
	//bice lista klinika 
	//private Set<String> listaKlinika; 
	
	@OneToMany(mappedBy="pacijent" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Pregled> pregledi = new HashSet<Pregled>();
	
	@Column(name = "zdravstveni_karton", nullable = false)
	private String zdravstveniKarton; 
	
	//@Column(name = "profil_korisnika", nullable = false)
	//private String profilKorisnika;
	
	public Pacijent() {
		super();
	} 
	
	public Pacijent(Long id, Korisnik korisnik, MedicinskaSestra medicinskaSestra, Ljekar ljekar,
			AdministratorKlinickogCentra administratorKlinickogCentra, Set<Pregled> pregledi,
			String zdravstveniKarton) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.medicinskaSestra = medicinskaSestra;
		this.ljekar = ljekar;
		this.administratorKlinickogCentra = administratorKlinickogCentra;
		this.pregledi = pregledi;
		this.zdravstveniKarton = zdravstveniKarton;
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

	public Ljekar getLjekar() {
		return ljekar;
	}

	public void setLjekar(Ljekar ljekar) {
		this.ljekar = ljekar;
	}

	
	public Set<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(Set<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public String getZdravstveniKarton() {
		return zdravstveniKarton;
	}

	public void setZdravstveniKarton(String zdravstveniKarton) {
		this.zdravstveniKarton = zdravstveniKarton;
	}

	public MedicinskaSestra getMedicinskaSestra() {
		return medicinskaSestra;
	}

	public void setMedicinskaSestra(MedicinskaSestra medicinskaSestra) {
		this.medicinskaSestra = medicinskaSestra;
	}

	public AdministratorKlinickogCentra getAdministratorKlinickogCentra() {
		return administratorKlinickogCentra;
	}

	public void setAdministratorKlinickogCentra(AdministratorKlinickogCentra administratorKlinickogCentra) {
		this.administratorKlinickogCentra = administratorKlinickogCentra;
	}
		
}
