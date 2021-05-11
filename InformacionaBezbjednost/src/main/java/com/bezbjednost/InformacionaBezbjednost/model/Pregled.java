package com.bezbjednost.InformacionaBezbjednost.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pregled")
public class Pregled {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pregleda", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "soba", nullable = false)
	private String soba;
	
	@Column(name = "datum", nullable = false)
	private Date datum;
	
	@Column(name = "opis", nullable = false)
	private String opis;
	
	@Column(name = "doktor", nullable = false)
	private String doktor;
	
	@Column(name = "pacijent", nullable = false)
	private String pacijent;

	
	
	public Pregled() {
		super();
	}

	public Pregled(Integer id, String soba, Date datum, String opis, String doktor, String pacijent) {
		super();
		this.id = id;
		this.soba = soba;
		this.datum = datum;
		this.opis = opis;
		this.doktor = doktor;
		this.pacijent = pacijent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSoba() {
		return soba;
	}

	public void setSoba(String soba) {
		this.soba = soba;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getDoktor() {
		return doktor;
	}

	public void setDoktor(String doktor) {
		this.doktor = doktor;
	}

	public String getPacijent() {
		return pacijent;
	}

	public void setPacijent(String pacijent) {
		this.pacijent = pacijent;
	}
	
}