package com.example.e_tron.controllers;

//import java.sql.SQLIntegrityConstraintViolationException;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_tron.entities.Carte;
import com.example.e_tron.entities.Utilisateur;
import com.example.e_tron.entities.Voiture;
import com.example.e_tron.response.InscriptionReponse;
import com.example.e_tron.services.CarteService;
import com.example.e_tron.services.UtilisateurService;



@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired 
	UtilisateurService utilisateurservice;
	@Autowired
	CarteService carteservice;
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> traitementValidationExceptions( MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	
	
	/*
	 * completer la validation des entré car spring validation ne permet pas de tout valider
	 * 
	 * */
	
	
	@PostMapping("/Inscription")
	public InscriptionReponse inscriptionUtilisateur(@Valid @RequestBody Utilisateur u)
	{		
		try 
		{
			utilisateurservice.createUtilisateur(u);
			Carte carte=carteservice.createCarte(u);
			return new InscriptionReponse(ResponseEntity.ok("Utilisateur ajouté, la carte s'expire apres 13 mois"),carte );
		}
		catch (Exception e) 
		{ 
			return new InscriptionReponse(new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST),null); 
		}

	}
	@PostMapping
	public VoitureController abonnementUtilisateur(@Valid @RequestBody Voiture v)
	{
		return null;
	}
}
