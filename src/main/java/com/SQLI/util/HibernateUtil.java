package com.sqli.util;
import com.sqli.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory factory;

	public static Configuration getInitializedConfiguration() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Action.class);
		config.addAnnotatedClass(Assiste.class);
		config.addAnnotatedClass(AssisteId.class);
		config.addAnnotatedClass(Collaborateur.class);
		config.addAnnotatedClass(Compte.class);
		config.addAnnotatedClass(Document.class);
		config.addAnnotatedClass(Evaluation.class);
		config.addAnnotatedClass(EvaluationChaud.class);
		config.addAnnotatedClass(EvaluationFroid.class);
		config.addAnnotatedClass(Formateur.class);
		config.addAnnotatedClass(Objectif.class);
		config.addAnnotatedClass(Profil.class);
		config.addAnnotatedClass(Reponse.class);
		config.addAnnotatedClass(Question.class);
		config.addAnnotatedClass(ReponseId.class);
		config.addAnnotatedClass(Session.class);
		config.addAnnotatedClass(Theme.class);




		config.configure();
		return config;
	}

	public static Session getSession() {
		if (factory == null) {
			Configuration config = HibernateUtil.getInitializedConfiguration();
			factory = config.buildSessionFactory();
		}
		Session hibernateSession = factory.getCurrentSession();
		return hibernateSession;
	}



	//                if (factory == null) {
		//                        Configuration config = HibernateUtil.getInitializedConfiguration();
		//                        factory = config.buildSessionFactory();
		//                }
	// Session hibernateSession = factory.getCurrentSession();


	public static void closeSession() {
		HibernateUtil.getSession().close();
	}

	public static void recreateDatabase() {
		Configuration config = HibernateUtil.getInitializedConfiguration();
		new SchemaExport(config).create(true,true);
	}

	public static Session beginTransaction() {
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}

	public static void commitTransaction() {
		HibernateUtil.getSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		HibernateUtil.getSession().getTransaction().rollback();
	}

	public static void main(String[] args) {
		HibernateUtil.recreateDatabase();
	}
}
