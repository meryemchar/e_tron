package com.example.e_tron.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.e_tron.dao.AbonnementDao;
import com.example.e_tron.entities.Abonnement;



@Service
public class AbonnementServiceImpl implements AbonnementService{
	
	@Autowired
	AbonnementDao abonnementdao;

	@Override
	public Abonnement createAbonnement(Abonnement v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Abonnement> getAllAbonnement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abonnement getAbonnementById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAbonnement(Abonnement v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Abonnement updateAbonnement(Abonnement v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}