package com.example.e_tron.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_tron.dao.UtilisateurDao;
import com.example.e_tron.entities.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	UtilisateurDao utilisateurdao;

	@Override
	public Utilisateur createUtilisateur(Utilisateur u) {
		u.setRole("user");
		u.setEstabonne(false);
		return utilisateurdao.save(u);
	}

	@Override
	public Utilisateur getUtilisateurById(Integer id) {
		// TODO Auto-generated method stub
		return utilisateurdao.getById(id);
	}

	@Override
	public void deleteUtilisateur(Utilisateur v) {
		// TODO Auto-generated method stub	
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getSimpleUtilisateur() {
		
		return utilisateurdao.findByRole("user");
	}

	@Override
	public List<Utilisateur> getAbonnees() {
		
		return utilisateurdao.findByEstabonne(true);
	}

	@Override
	public List<Utilisateur> getNonAbonnees() {
		return utilisateurdao.findByEstabonne(false);
	}

	@Override
	public Utilisateur getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
