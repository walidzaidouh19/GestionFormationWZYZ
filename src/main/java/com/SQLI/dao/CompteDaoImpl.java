package com.sqli.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sqli.model.Compte;
import com.sqli.model.Personnel;
import com.sqli.util.HibernateUtil;


public class CompteDaoImpl implements CompteDaoInt,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompteDaoImpl(){
		System.err.println("Instanciation de compteServ");
	}

	public void addCompte(Compte compte, Personnel p){
		System.err.println("appel de addCompte");
		System.err.println("CIN :" + compte.getPersonnel()+"login :"+compte.getLogin()+"Mot De passe :"+compte.getPassword());
		Session ses = HibernateUtil.getSession();
		compte.setPersonnel(p);
		try {
		ses.beginTransaction();
		ses.save(compte);
		ses.getTransaction().commit();
		//ses.close();
		System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Compte> listCompte(){
		List<Compte> l =null;
		Session ses = HibernateUtil.getSession();
		try {
		ses.beginTransaction();
		l= ses.createQuery("from Compte").list(); 
		ses.getTransaction().commit();
		//ses.close();
	} catch (Exception e) {
		System.out.print("erreur suppression " + e.getMessage());
		ses.beginTransaction().rollback();
		return l;
	}
	return l;
}

	// @Override
	public void updateCompte(Compte compte) {

		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(compte);
			session.getTransaction().commit();
			//session.close();
			System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
		}
	}

	// @Override
	public void deletcompte(Compte compte) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(compte);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	// @Override
	public Compte getCompte(Integer id) {

		Compte compte= null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			compte = (Compte) session.get(Compte.class, id);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
			return compte;
		}
		return compte;
	}
	
	public Compte getCompteS(String id) {
		System.out.println("test Out of function");
		Compte compte= null;
		List<Compte> listobject=null;
	
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
		//	compte = (Compte) session.get(Compte.class, id);
			listobject=listCompte();
			for (Compte cmt : listobject ) {
				if(cmt.getLogin().equals(id)){
					System.out.println( "  compte de password "+cmt.getPassword());
					compte=cmt;	
				}
			}	
			
		} catch (Exception e) {
			System.out.print("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
			return compte;
		}
		return compte;
	}
	public Compte getCompteO(Object object) {
		Compte compte= null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			compte = (Compte) session.get(Compte.class, (Serializable) object);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
			return compte;
		}
		return compte;
	}
}