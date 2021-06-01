package com.bezbjednost.InformacionaBezbjednost.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
	private EUloga uloga;
	
	@OneToMany(mappedBy = "authority", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<KorisnikAuthorithy> userAuthorities = new ArrayList<KorisnikAuthorithy>();

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EUloga getUloga() {
		return uloga;
	}

	public void setUloga(EUloga uloga) {
		this.uloga = uloga;
	}

	public List<KorisnikAuthorithy> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(List<KorisnikAuthorithy> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
	
	
}
