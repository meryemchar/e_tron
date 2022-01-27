package com.example.e_tron.controllers;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_tron.entities.Abonnement;
import com.example.e_tron.services.AbonnementService;
@RestController
@RequestMapping("abonnement")
public class AbonnementController {
	
	@Autowired
	private AbonnementService abonnementservice;
	
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
	
	@PostMapping
	public ResponseEntity<String> creerAbonnement(@Valid @RequestBody Abonnement abonnement)
	{
		try {
			abonnementservice.createAbonnement(abonnement);
			return ResponseEntity.ok("abonnement ajouté");
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);  
				
		}
	}
	
	@GetMapping
	public List<Abonnement> listAbonnemnt()
	{
		return abonnementservice.getAllAbonnement();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> supprimerAbonnement(@PathVariable("id") Integer id)
	{
		try {
			abonnementservice.deleteAbonnement(id);
			return ResponseEntity.ok("Abonnement supprime");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping()
	public ResponseEntity<String> modifierAbonnement(@RequestBody Abonnement a)
	{
		try {
			abonnementservice.updateAbonnement(a);
			return new ResponseEntity<String>("abonnement modifié", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
