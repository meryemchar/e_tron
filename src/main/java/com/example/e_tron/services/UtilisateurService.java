package com.example.e_tron.services;

import java.util.List;

import com.example.e_tron.entities.Utilisateur;

public interface UtilisateurService {
		
	public Utilisateur createUtilisateur(Utilisateur v);
	public List<Utilisateur> getAllUtilisateur();
	public Utilisateur getUtilisateurById(Integer id);
	public void deleteUtilisateur(Utilisateur v);
	public Utilisateur updateUtilisateur(Utilisateur v);

}
