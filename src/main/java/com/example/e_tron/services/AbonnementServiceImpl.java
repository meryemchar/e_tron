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
		return abonnementdao.save(v);
	}

	@Override
	public List<Abonnement> getAllAbonnement() {
		// TODO Auto-generated method stub
		return abonnementdao.findAll();
	}

	@Override
	public Abonnement getAbonnementById(Integer id) {
		// TODO Auto-generated method stub
		return abonnementdao.getById(id);
	}

	@Override
	public void deleteAbonnement(Integer id) {
		// TODO Auto-generated method stub
		abonnementdao.deleteById(id);
	}

	@Override
	public Abonnement updateAbonnement(Abonnement v) {
		// TODO Auto-generated method stub
		return abonnementdao.save(v);
	}

	@Override
	public Abonnement getbyType(String type) {
		// TODO Auto-generated method stub
		List<Abonnement> a=abonnementdao.findByType(type);
		return a.get(0);
	}
	
	

}
