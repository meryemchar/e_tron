package com.example.e_tron.controllers;

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

import com.example.e_tron.entities.Utilisateur;
import com.example.e_tron.services.UtilisateurService;



@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired 
	UtilisateurService utilisateurservice;
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions( MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	
	
	@PostMapping()
	public ResponseEntity<String> createUtilisateur(@Valid @RequestBody  Utilisateur u)
	{
		u.setRole("user");
		u.setEstabonne(false);
		Utilisateur nouveau_utilisateur= utilisateurservice.createUtilisateur(u);
		return ResponseEntity.ok("Utilisateur ajouté");
	}

}
