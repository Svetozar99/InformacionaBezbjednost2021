package com.bezbjednost.InformacionaBezbjednost.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bezbjednost.InformacionaBezbjednost.dtos.PregledDTO;
import com.bezbjednost.InformacionaBezbjednost.serviceInterface.PregledServiceInterface;

@RestController
@RequestMapping(value = "/api")
public class PregledController {

	@Autowired
	private PregledServiceInterface psi;
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_KLINICKOG_CENTRA', 'MEDICINSKA_SESTRA')")
	@GetMapping("/auth/test")
	public String test() {
		return "test";
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_KLINIKE', 'ADMINISTRATOR_KLINICKOG_CENTRA', 'MEDICINSKA_SESTRA')")
	@RequestMapping(value="/auth/allPregledi", method= RequestMethod.GET)
	public ResponseEntity<List<PregledDTO>> getPregledi(){
		return ResponseEntity.ok().body(psi.findAll());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_KLINIKE', 'ADMINISTRATOR_KLINICKOG_CENTRA', 'MEDICINSKA_SESTRA', 'PACIJENT')")
	@GetMapping(value = "/auth/pregled/{id}")
	public ResponseEntity<PregledDTO> getPregled(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(psi.findOneById(id));
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_KLINIKE', 'ADMINISTRATOR_KLINICKOG_CENTRA', 'MEDICINSKA_SESTRA', 'PACIJENT')")
	@RequestMapping(value="/auth/addPregled", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PregledDTO> addPregled(@RequestBody PregledDTO pdto){
		return ResponseEntity.ok().body(psi.save(pdto));
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_KLINIKE', 'ADMINISTRATOR_KLINICKOG_CENTRA', 'MEDICINSKA_SESTRA', 'PACIJENT')")
	@RequestMapping(value="/auth/updatePregled", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Void> update(@RequestBody PregledDTO pDTO, @PathVariable("id") Integer id) throws ParseException{
		try {
			psi.update(id, pDTO);
			return ResponseEntity.noContent().build();
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_KLINIKE', 'ADMINISTRATOR_KLINICKOG_CENTRA', 'MEDICINSKA_SESTRA')")
	@RequestMapping(value="/auth/updatePregled", method=RequestMethod.DELETE, consumes="application/json")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		psi.remove(id);
		return ResponseEntity.noContent().build();
	}
}
