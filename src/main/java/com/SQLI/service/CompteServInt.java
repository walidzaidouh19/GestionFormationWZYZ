package com.sqli.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.sqli.model.Compte;
import com.sqli.model.Personnel;

@Transactional
public interface CompteServInt {
	public void addCompte(Compte compte , Personnel p);
	public void updateCompte(Compte compte);
	public void deletcompte(Compte compte);
	public Compte getCompte(Integer id);
	public List<Compte> listCompte();
	public Compte getCompteS(String login);
	public Compte getCompteO(Object object);
}
