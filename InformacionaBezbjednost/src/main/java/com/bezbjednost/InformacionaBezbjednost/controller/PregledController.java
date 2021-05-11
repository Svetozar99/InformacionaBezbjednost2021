package com.bezbjednost.InformacionaBezbjednost.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezbjednost.InformacionaBezbjednost.dtos.PregledDTO;
import com.bezbjednost.InformacionaBezbjednost.serviceInterface.PregledServiceInterface;

@RestController
@RequestMapping(value = "api/pregled")
public class PregledController {

	@Autowired
	private PregledServiceInterface psi;
	
	@GetMapping
	public ResponseEntity<List<PregledDTO>> getPregledi(){
		return ResponseEntity.ok().body(psi.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PregledDTO> getPregled(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(psi.findOneById(id));
	}
	
	@PostMapping
	public ResponseEntity<PregledDTO> addPregled(@RequestBody PregledDTO pdto){
		return ResponseEntity.ok().body(psi.save(pdto));
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Void> update(@RequestBody PregledDTO pDTO, @PathVariable("id") Integer id) throws ParseException{
		try {
			psi.update(id, pDTO);
			return ResponseEntity.noContent().build();
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		psi.remove(id);
		return ResponseEntity.noContent().build();
	}
}
