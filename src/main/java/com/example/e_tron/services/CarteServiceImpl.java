package com.example.e_tron.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_tron.dao.CarteDao;
import com.example.e_tron.entities.Carte;
import com.example.e_tron.entities.Utilisateur;
@Service
public class CarteServiceImpl implements CarteService{
	
	@Autowired
	CarteDao cartedao;

	@Override
	public Carte createCarte(Utilisateur u) {
		
		String numCarte= "A"+u.getId()*1545+123;
		Date date_inscription= new Date();
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.MONTH, 13);
		Date date_expiration=  cal.getTime();
		Carte c=new Carte(null, numCarte, date_inscription, date_expiration, u);
		
		return cartedao.save(c);
	}

	@Override
	public List<Carte> getAllCarte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carte getCarteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCarte(Carte v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carte updateCarte(Carte v) {
		// TODO Auto-generated method stub
		return null;
	}

}
