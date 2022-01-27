package com.example.e_tron.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Voiture {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@NotBlank(message = "Le matricule ne peut pas être vide")
	private String matricule;
	//@NotBlank(message = "Le modele ne peut pas être vide")
	private String modele;
	//@NotBlank(message = "La couleur ne peut pas être vide")
	private String couleur;
	@ManyToOne 
	private Utilisateur utilisateur;
	@ManyToOne
	private Abonnement abonnement;
	
	
	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Voiture(Integer id, String matricule, String modele, String couleur, Utilisateur utilisateur,
			Abonnement abonnement) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.modele = modele;
		this.couleur = couleur;
		this.utilisateur = utilisateur;
		this.abonnement = abonnement;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Abonnement getAbonnement() {
		return abonnement;
	}


	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	
}
