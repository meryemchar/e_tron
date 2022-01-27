package com.example.e_tron.response;

import org.springframework.http.ResponseEntity;

import com.example.e_tron.entities.Carte;

public class InscriptionReponse {
	
	private ResponseEntity<String> reponse;
	private Carte carte;
	
	
	public InscriptionReponse(ResponseEntity<String> reponse, Carte carte) {
		super();
		this.reponse = reponse;
		this.carte = carte;
	}
	
	public ResponseEntity<String> getReponse() {
		return reponse;
	}
	public void setReponse(ResponseEntity<String> reponse) {
		this.reponse = reponse;
	}
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	

}
