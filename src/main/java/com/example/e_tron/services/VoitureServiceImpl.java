package com.example.e_tron.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_tron.dao.VoitureDao;
import com.example.e_tron.entities.Voiture;

@Service
public class VoitureServiceImpl implements VoitureService {
	
	@Autowired
	private VoitureDao voituredao;

	@Override
	public Voiture createVoiture(Voiture v) {
		
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

}
