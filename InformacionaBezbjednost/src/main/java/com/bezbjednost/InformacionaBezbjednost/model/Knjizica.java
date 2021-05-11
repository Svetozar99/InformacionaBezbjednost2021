package com.bezbjednost.InformacionaBezbjednost.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "knjizica")
public class Knjizica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_knjizice", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "broj", nullable = false)
	private Integer broj;
	
	@Column(name = "datum_isteka", nullable = false)
	private Date datumIsteka;

	public Knjizica() {
		super();
	}

	public Knjizica(Integer id, Integer broj, Date datumIsteka) {
		super();
		this.id = id;
		this.broj = broj;
		this.datumIsteka = datumIsteka;
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
