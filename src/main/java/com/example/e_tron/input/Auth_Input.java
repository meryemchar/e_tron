package com.example.e_tron.input;

public class Auth_Input {
	
	private String email;
	private String mdp;
	
	
	
	public Auth_Input() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Auth_Input(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	

}
