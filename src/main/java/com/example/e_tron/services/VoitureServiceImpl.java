package com.example.e_tron.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_tron.dao.VoitureDao;
import com.example.e_tron.entities.Abonnement;
import com.example.e_tron.entities.Carte;
import com.example.e_tron.entities.Utilisateur;
import com.example.e_tron.entities.Voiture;
import com.example.e_tron.input.AbonnementInput;

@Service
public class VoitureServiceImpl implements VoitureService {
	
	@Autowired
	private VoitureDao voituredao;
	@Autowired
	private CarteService carteservice;
	@Autowired
	private UtilisateurService utilisateurservice;
	@Autowired
	private AbonnementService abonnementservice;
	@Override
	public Voiture createVoiture(Voiture v ) {

		return voituredao.save(v);
	}

	@Override
	public List<Voiture> getAllVoiture() {
		// TODO Auto-generated method stub
		return voituredao.findAll();
	}

	@Override
	public Voiture getVoitureById(Integer id) {
		// TODO Auto-generated method stub
		return voituredao.getById(id);
	}

	@Override
	public void deleteVoiture(Integer id) {
		//voituredao.delete(v);
		voituredao.deleteById(id);

	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		voituredao.save(v);		
		return null;

	}
	
	
	
	
	@Override
	public Voiture creerAbonnement(AbonnementInput a)
	{
		Carte carte= carteservice.getByNum(a.getNumcarte());
		Utilisateur utilisateur= carte.getUtilisateur();
		utilisateur.setEstabonne(true);
		utilisateurservice.updateUtilisateur(utilisateur);
		Abonnement abonnement=abonnementservice.getbyType(a.gettypeAbonnement());
		String matricule=a.getVoiture().getMatricule();
		String couleur=a.getVoiture().getCouleur();
		String modele=a.getVoiture().getModele();
		Voiture voiture=new Voiture(null,matricule , modele, couleur, utilisateur, abonnement);
		return voituredao.save(voiture);
		
	}

	@Override
	public Voiture modifierAbonnement(AbonnementInput a) {
		
		Voiture v=a.getVoiture();
		
		Carte carte= carteservice.getByNum(a.getNumcarte());
		
		Utilisateur utilisateur= carte.getUtilisateur();
		
		Abonnement abonnement=abonnementservice.getbyType(a.gettypeAbonnement());
		
		v.setAbonnement(abonnement);
		v.setUtilisateur(utilisateur);
		
		return voituredao.save(v);
	}

}
