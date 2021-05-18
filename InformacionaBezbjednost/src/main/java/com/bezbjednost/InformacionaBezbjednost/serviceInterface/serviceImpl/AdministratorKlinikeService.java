package com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezbjednost.InformacionaBezbjednost.model.AdministratorKlinike;
import com.bezbjednost.InformacionaBezbjednost.repository.AdministratorKlinikeRepository;

@Service
public class AdministratorKlinikeService {
	
	@Autowired
	AdministratorKlinikeRepository administratorKlinikeRepository; 
	
	public AdministratorKlinike findOne(Long id) {
		return administratorKlinikeRepository.findById(id).orElse(null);

	}

}
