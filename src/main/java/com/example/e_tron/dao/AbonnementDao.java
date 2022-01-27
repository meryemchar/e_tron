package com.example.e_tron.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.e_tron.entities.Abonnement;

@Repository
public interface AbonnementDao extends JpaRepository<Abonnement, Integer>{
	List<Abonnement> findByType(String type);
	
}
