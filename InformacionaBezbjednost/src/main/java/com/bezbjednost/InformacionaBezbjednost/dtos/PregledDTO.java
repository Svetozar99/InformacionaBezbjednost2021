package com.bezbjednost.InformacionaBezbjednost.dtos;

import java.util.Date;

import com.bezbjednost.InformacionaBezbjednost.model.Pregled;

public class PregledDTO {

	private Integer id;
	private String soba;
	private Date datum;
	private String opis;
	private String doktor;
	private String pacijent;
	
	public PregledDTO() {
		super();
	}
	
	public PregledDTO(Pregled p) {
		super();
		this.id = p.getId();
		this.soba = p.getSoba();
		this.datum = p.getDatum();
		this.opis = p.getOpis();
		this.doktor = p.getDoktor();
		this.pacijent = p.getPacijent();
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
