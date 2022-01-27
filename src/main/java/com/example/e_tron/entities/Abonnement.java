package com.example.e_tron.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Abonnement {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Le type d'abonnement ne peut pas être vide")
	private String type;
	//@NotBlank(message = "Le tarif ne peut pas être vide")
	@Column(nullable = false)
	private double tarif;
	@OneToMany(mappedBy ="abonnement")
	private List<Voiture> listevoiture;
	
	
	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Abonnement(Integer id, String type, double tarif, List<Voiture> listevoiture) {
		super();
		this.id = id;
		this.type = type;
		this.tarif = tarif;
		this.listevoiture = listevoiture;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getTarif() {
		return tarif;
	}


	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

@JsonIgnore
	public List<Voiture> getListevoiture() {
		return listevoiture;
	}


	public void setListevoiture(List<Voiture> listevoiture) {
		this.listevoiture = listevoiture;
	}

	

}
