package com.sqli.dao;

import java.util.List;
import com.sqli.model.*;


public interface CompteDaoInt {
	
	public void addCompte(Compte compte , Personnel p);
	public void updateCompte(Compte compte);
	public void deletcompte(Compte compte);
	public Compte getCompte(Integer id);
	public List<Compte> listCompte();
	public Compte getCompteS(String login);
	public Compte getCompteO(Object object);
	
}
