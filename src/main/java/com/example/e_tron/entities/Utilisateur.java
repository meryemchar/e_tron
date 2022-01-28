package com.example.e_tron.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@Column(nullable = false)
	@NotBlank(message = "Le nom ne peut pas être vide")
	private String nom;
	@NotBlank(message = "Le prenom ne peut pas être vide")
	private String prenom;
	//@NotBlank(message = "La date de naissance ne peut pas être vide") // on ne pas utilisé notnull avec une date
	@Column(nullable = false)
	private Date dateNaissance;
	@NotBlank(message = "La CIN ne peut pas être vide")
	@Column(unique = true)
	private String CIN;
	@NotBlank(message = "Le genre ne peut pas être vide")
	private String genre;
	@NotBlank(message = "L'email ne peut pas être vide")
	@Column(unique = true)
	private String email;
	@NotBlank(message = "Le mot de passe ne peut pas être vide")
	@Size(min = 8, max = 32, message = "le mot de passe doit contenir en minimum 8 caractères") 
	private String mdp;
	private Boolean estabonne;
	private String role;
	@JsonIgnore
	@OneToMany(mappedBy ="utilisateur")
	private List<Voiture> listevoiture;
	
	@OneToOne(mappedBy ="utilisateur")
	private Carte carte;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Integer id, String nom, String prenom, Date dateNaissance, String cIN, String genre, String email,
			String mdp, Boolean estabonne, String role, List<Voiture> listevoiture, Carte carte) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.CIN = cIN;
		this.genre = genre;
		this.email = email;
		this.mdp = mdp;
		this.estabonne = estabonne;
		this.role = role;
		this.listevoiture = listevoiture;
		this.carte = carte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Boolean getEstabonne() {
		return estabonne;
	}

	public void setEstabonne(Boolean estabonne) {
		this.estabonne = estabonne;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Voiture> getListevoiture() {
		return listevoiture;
	}

	public void setListevoiture(List<Voiture> listevoiture) {
		this.listevoiture = listevoiture;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	
	
	
	
	
	
	
}
