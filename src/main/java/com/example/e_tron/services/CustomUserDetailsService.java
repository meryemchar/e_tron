package com.example.e_tron.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.e_tron.dao.UtilisateurDao;
import com.example.e_tron.entities.Utilisateur;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UtilisateurDao user_dao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur utilisateur=  user_dao.findByEmail(email).get(0); 
		return new org.springframework.security.core.userdetails.User(email, utilisateur.getMdp(), new ArrayList<>());
	}

}
