package com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezbjednost.InformacionaBezbjednost.model.Ljekar;
import com.bezbjednost.InformacionaBezbjednost.repository.LjekarRepository;

@Service
public class LjekarService {
	
	@Autowired
	LjekarRepository ljekarRepository; 
	
	public Ljekar findOne(Long id) {
		return ljekarRepository.findById(id).orElse(null);
	}
	
	public List<Ljekar> findAll(){
		return ljekarRepository.findAll(); 
	}
	
	public Ljekar save(Ljekar ljekar) {
		return ljekarRepository.save(ljekar);
	}
	
	public void remove(Long id) {
		ljekarRepository.deleteById(id);
	}
	
	
	
}
