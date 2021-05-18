package com.bezbjednost.InformacionaBezbjednost.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bezbjednost.InformacionaBezbjednost.dtos.LjekarDTO;
import com.bezbjednost.InformacionaBezbjednost.model.AdministratorKlinike;
import com.bezbjednost.InformacionaBezbjednost.model.Korisnik;
import com.bezbjednost.InformacionaBezbjednost.model.Ljekar;
import com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl.AdministratorKlinikeService;
import com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl.KorisnikService;
import com.bezbjednost.InformacionaBezbjednost.serviceInterface.serviceImpl.LjekarService;

@RestController
@RequestMapping(value = "api/ljekar")
public class LjekarController {
	
	@Autowired
	private LjekarService ljekarService; 
	
	@Autowired
	private KorisnikService korisnikService; 
	
	@Autowired
	private AdministratorKlinikeService administratorKlinikeService; 
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<LjekarDTO>> getAllLjekari(){
		
		List<Ljekar> ljekari = ljekarService.findAll(); 
		List<LjekarDTO> dtos = new ArrayList<>();
		
		for(Ljekar ljekar: ljekari) {
			dtos.add(new LjekarDTO(ljekar));
		}
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<LjekarDTO> getLjekar(@PathVariable Long id){
		Ljekar ljekar = ljekarService.findOne(id);
		
		if(ljekar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<LjekarDTO>(new LjekarDTO(ljekar), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<LjekarDTO> saveLjekar(@RequestBody LjekarDTO ljekarDTO){
		Ljekar ljekar = new Ljekar();
		ljekar.setIme(ljekarDTO.getIme());
		ljekar.setPrezime(ljekarDTO.getPrezime());
		ljekar.setKorisnickoIme(ljekarDTO.getKorisnickoIme());
		ljekar.setKorisnik(null);
		ljekar.setAdministratorKlinike(null);
		
		//korisnik = korisnikService.findOne(ljekarDTO.getKorisnikDTO().getId());
		
		//AdministratorKlinike administratorKlinike = administratorKlinikeService.findOne(ljekarDTO.getAdministratorKlinikeDTO().getId());
		/*
		if(administratorKlinike == null) {
			ljekar.setAdministratorKlinike(null);
		} else {
			ljekar.setAdministratorKlinike(administratorKlinike);
		}
		*/
		ljekar = ljekarService.save(ljekar);
		return new ResponseEntity<>(new LjekarDTO(ljekar), HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{id}",consumes="application/json")
	public ResponseEntity<LjekarDTO> updateLjekar(@RequestBody LjekarDTO ljekarDTO, @PathVariable("id") Long id) {
		
		Ljekar ljekar = ljekarService.findOne(id);
		
		if (ljekar == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		ljekar.setIme(ljekarDTO.getIme());
		ljekar.setPrezime(ljekarDTO.getPrezime());
		ljekar.setKorisnickoIme(ljekarDTO.getKorisnickoIme());
		ljekar.setKorisnik(null);
		ljekar.setAdministratorKlinike(null);
		
		//Korisnik korisnik = korisnikService.findOne(ljekarDTO.getKorisnikDTO().getId());
		//AdministratorKlinike administratorKlinike = administratorKlinikeService.findOne(ljekarDTO.getAdministratorKlinikeDTO().getId());
		
		//ljekar.setKorisnik(korisnik);
		//ljekar.setAdministratorKlinike(administratorKlinike);
		
		ljekar = ljekarService.save(ljekar);
		return new ResponseEntity<>(new LjekarDTO(ljekar), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLjekar(@PathVariable Long id){
		Ljekar ljekar = ljekarService.findOne(id);
		
		if(ljekar != null) {
			ljekarService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
