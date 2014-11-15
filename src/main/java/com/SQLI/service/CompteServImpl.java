package com.sqli.service;



import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sqli.dao.CompteDaoInt;
import com.sqli.model.Compte;
import com.sqli.model.Personnel;

/**
 * @author WALID
 *
 */
public class CompteServImpl implements CompteServInt, Serializable{

	private CompteDaoInt dao;


	@Override
	public void addCompte(Compte compte, Personnel p) {
	dao.addCompte(compte, p);
	}

	@Override
	public void updateCompte(Compte compte) {
		dao.updateCompte(compte);
		
	}

	@Override
	public void deletcompte(Compte compte) {
	dao.deletcompte(compte);
		
	}

	@Override
	public Compte getCompte(Integer id) {
		return dao.getCompte(id);
	}

	@Override
	public List<Compte> listCompte() {
	return dao.listCompte();
	}

	@Override
	public Compte getCompteS(String login) {
	return dao.getCompteS(login);
	}
	@Override
	public Compte getCompteO(Object object) {
	return dao.getCompteO(object);
	}

	public CompteDaoInt getDao() {
		return dao;
	}

	public void setDao(CompteDaoInt dao) {
		this.dao = dao;
	}

}
