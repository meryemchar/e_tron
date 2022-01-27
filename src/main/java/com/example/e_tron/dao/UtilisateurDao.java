package com.example.e_tron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.e_tron.entities.Utilisateur;
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer>{
	

	public List<Utilisateur> findByRole(String role);
	public List<Utilisateur> findByEstabonne(Boolean estabonne);
	public List<Utilisateur> findByEmail(String email);

}
