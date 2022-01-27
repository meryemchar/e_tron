package com.example.e_tron.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.validation.constraints.NotBlank;
@Entity
public class Carte {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@NotBlank(message = "Le numero de la carte ne peut pas être vide")
	private String numcarte;
	//@NotBlank(message = "La date de création ne peut pas être vide")
	private Date datecreation;
	//@NotBlank(message = "La date d'expiration ne peut pas être vide")
	private Date dateexpiration;
	@OneToOne
	private Utilisateur utilisateur;
	
	
	public Carte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Carte(String numcarte, Date datecreation, Date dateexpiration, Utilisateur utilisateur) {
		super();
		this.numcarte = numcarte;
		this.datecreation = datecreation;
		this.dateexpiration = dateexpiration;
		this.utilisateur = utilisateur;
	}


	public Carte(Integer id, String numcarte, Date datecreation, Date dateexpiration, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.numcarte = numcarte;
		this.datecreation = datecreation;
		this.dateexpiration = dateexpiration;
		this.utilisateur = utilisateur;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumcarte() {
		return numcarte;
	}
	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	public Date getDateexpiration() {
		return dateexpiration;
	}
	public void setDateexpiration(Date dateexpiration) {
		this.dateexpiration = dateexpiration;
	}
	@JsonIgnore
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
}
