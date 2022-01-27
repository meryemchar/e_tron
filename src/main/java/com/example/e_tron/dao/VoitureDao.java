package com.example.e_tron.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.e_tron.entities.Voiture;
@Repository
public interface VoitureDao extends JpaRepository<Voiture, Integer> {

}
