package com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezbjednost.InformacionaBezbjednost.dtos.PregledDTO;
import com.bezbjednost.InformacionaBezbjednost.model.Pregled;
import com.bezbjednost.InformacionaBezbjednost.repository.PregledRepository;
import com.bezbjednost.InformacionaBezbjednost.serviceInterface.PregledServiceInterface;

@Service
public class PregledService implements PregledServiceInterface {

	@Autowired
	PregledRepository pregledRepository;
	
	@Override
	public List<PregledDTO> findAll() {
		List<Pregled> pregledi = pregledRepository.findAll();
	
		List<PregledDTO> dtos = new ArrayList<PregledDTO>();
		for(Pregled p: pregledi) {
			dtos.add(new PregledDTO(p));
		}
		return dtos;
	}

	@Override
	public PregledDTO findOneById(Integer id) {
		Pregled p = pregledRepository.getOne(id);
		return new PregledDTO(p);
		
	}

	@Override
	public PregledDTO save(PregledDTO p) {
		Pregled pr = new Pregled();
		pr.setSoba(p.getSoba());
		pr.setDatum(p.getDatum());
		pr.setOpis(p.getOpis());
		//pr.setDoktor(p.getDoktor());
		pr.setPacijent(p.getPacijent());
		
		pr = pregledRepository.save(pr);
		
		return new PregledDTO(pr);
	}

	@Override
	public void remove(Integer id) {
		pregledRepository.deleteById(id);
	}

	@Override
	public PregledDTO update(Integer id, PregledDTO p)  throws ParseException{
		Pregled pr = pregledRepository.getOne(id);
		
		pr.setSoba(p.getSoba());
		pr.setDatum(p.getDatum());
		pr.setOpis(p.getOpis());
		//pr.setDoktor(p.getDoktor());
		pr.setPacijent(p.getPacijent());
		
		pr = pregledRepository.save(pr);
		return new PregledDTO(pr);
	}
}
