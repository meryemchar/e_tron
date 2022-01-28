package com.example.e_tron.controllers;

//import java.sql.SQLIntegrityConstraintViolationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.e_tron.entities.Carte;
import com.example.e_tron.entities.Utilisateur;
import com.example.e_tron.entities.Voiture;
import com.example.e_tron.input.AbonnementInput;
import com.example.e_tron.input.Auth_Input;
import com.example.e_tron.output.InscriptionReponse;
import com.example.e_tron.services.CarteService;
import com.example.e_tron.services.CustomUserDetailsService;
import com.example.e_tron.services.UtilisateurService;
import com.example.e_tron.services.VoitureService;
import com.example.e_tron.util.JwtUtil;


@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired 
	UtilisateurService utilisateurservice;
	@Autowired
	CarteService carteservice;
	@Autowired
	VoitureService voitureservice;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationmanager;
	@Autowired
	private CustomUserDetailsService userdetailsService;
	
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
	 * completer la validation des entres car spring validation ne permet pas de tout valider
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
	
	@GetMapping("/SimplesUtilisateurs")
	public List<Utilisateur> affichageUtilisateur()
	{
		return utilisateurservice.getSimpleUtilisateur() ;
	}
	
	@GetMapping("/Abonnes")
	public List<Utilisateur> affichageabonnes()
	{
		return utilisateurservice.getAbonnees() ;
	}
	
	@GetMapping("/NonAbonnes")
	public List<Utilisateur> affichageNonAbonnes()
	{
		return utilisateurservice.getNonAbonnees();
	}
	
	
	@PostMapping("/connexion")
	public String authentifiaction(@RequestBody Auth_Input auth) throws Exception
	{
		 try {
	            authenticationmanager.authenticate(
	                    new UsernamePasswordAuthenticationToken(auth.getEmail(), auth.getMdp())
	            );
	        } catch (Exception ex) {
	            throw new Exception("email ou mot de passe invalid");
	        }
		 final UserDetails userd=userdetailsService.loadUserByUsername(auth.getEmail());
	        return jwtUtil.generateToken(auth.getEmail()); 
	}
	
	
	@PostMapping("/abonnement")
	public ResponseEntity<String> Sabonner(@Valid @RequestBody AbonnementInput a)
	{
		
		try {
			Voiture v=voitureservice.creerAbonnement(a);
			return new ResponseEntity<String>("Abonnemnt enregistré",HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/modifierAbonnement")
	public ResponseEntity<Object> ModifierAbonnemnt(@Valid @RequestBody AbonnementInput a)
	{
		try {
			Voiture v=voitureservice.modifierAbonnement(a);
			return new ResponseEntity<Object>(v,HttpStatus.ACCEPTED );
		} catch (Exception e) {
		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
}
