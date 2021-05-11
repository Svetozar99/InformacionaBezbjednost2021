package com.bezbjednost.InformacionaBezbjednost.serviceInterface;

import java.text.ParseException;
import java.util.List;

import com.bezbjednost.InformacionaBezbjednost.dtos.PregledDTO;

public interface PregledServiceInterface {

	public List<PregledDTO> findAll();
	public PregledDTO findOneById(Integer id);
	public PregledDTO save(PregledDTO p);
	public void remove(Integer id);
	public PregledDTO update(Integer id, PregledDTO p)  throws ParseException;
}
