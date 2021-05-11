package com.bezbjednost.InformacionaBezbjednost.dtos;

import java.util.Date;

import com.bezbjednost.InformacionaBezbjednost.model.Knjizica;

public class KnjizicaDTO {

	private Integer id;
	private Integer broj;
	private Date datumIsteka;
	
	public KnjizicaDTO() {
		super();
	}
	
	public KnjizicaDTO(Knjizica k) {
		super();
		this.id = k.getId();
		this.broj = k.getBroj();
		this.datumIsteka = k.getDatumIsteka();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBroj() {
		return broj;
	}

	public void setBroj(Integer broj) {
		this.broj = broj;
	}

	public Date getDatumIsteka() {
		return datumIsteka;
	}

	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}
	
}
