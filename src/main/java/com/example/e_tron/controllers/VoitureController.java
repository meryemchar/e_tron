package com.example.e_tron.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_tron.entities.Voiture;
import com.example.e_tron.services.VoitureService;

@RestController
@RequestMapping("/voiture")
public class VoitureController {
	
	@Autowired
	VoitureService voitureservice;
	
	@PostMapping()
	public Voiture createVoiture (@RequestBody Voiture v)
	{
		return voitureservice.createVoiture(v);
	}
	
	@GetMapping()
	public List<Voiture> getallvoiture()
	{
		return voitureservice.getAllVoiture();
	}
	
	public void deletevoiture(Integer id)
	{
		voitureservice.deleteVoiture(id);
	}
	

}
