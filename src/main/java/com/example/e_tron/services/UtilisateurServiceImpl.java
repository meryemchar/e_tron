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
		
		return utilisateurdao.save(u);
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUtilisateurById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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

}
