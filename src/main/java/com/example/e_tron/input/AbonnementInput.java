package com.example.e_tron.input;

import com.example.e_tron.entities.Voiture;

public class AbonnementInput {
	
	private Voiture voiture;
	private String numcarte;
	private String typeAbonnement;
	
	public AbonnementInput() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public String getNumcarte() {
		return numcarte;
	}
	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

	public String gettypeAbonnement() {
		return typeAbonnement;
	}

	public void settypeAbonnement(String typeAbonnement) {
		this.typeAbonnement = typeAbonnement;
	}
	
	
}
