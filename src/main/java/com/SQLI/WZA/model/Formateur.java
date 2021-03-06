package com.SQLI.WZA.model;

// Generated 2 nov. 2014 19:02:33 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Formateur generated by hbm2java
 */
@Entity
@Table(name = "formateur", catalog = "gestionformation")
public class Formateur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idFormateur;
	private String nom;
	private String prenom;
	private String adrFormateur;
	private boolean collaInterne;
	private String site;
	private String diplome;
	private Set<Session> sessions = new HashSet<Session>(0);

	public Formateur() {
	}

	public Formateur(String nom, String prenom, String adrFormateur,
			boolean collaInterne, String diplome) {
		this.nom = nom;
		this.prenom = prenom;
		this.adrFormateur = adrFormateur;
		this.collaInterne = collaInterne;
		this.diplome = diplome;
	}

	public Formateur(String nom, String prenom, String adrFormateur,
			boolean collaInterne, String site, String diplome,
			Set<Session> sessions) {
		this.nom = nom;
		this.prenom = prenom;
		this.adrFormateur = adrFormateur;
		this.collaInterne = collaInterne;
		this.site = site;
		this.diplome = diplome;
		this.sessions = sessions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_formateur", unique = true, nullable = false)
	public Integer getIdFormateur() {
		return this.idFormateur;
	}

	public void setIdFormateur(Integer idFormateur) {
		this.idFormateur = idFormateur;
	}

	@Column(name = "nom", nullable = false)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "adr_formateur", nullable = false, length = 512)
	public String getAdrFormateur() {
		return this.adrFormateur;
	}

	public void setAdrFormateur(String adrFormateur) {
		this.adrFormateur = adrFormateur;
	}

	@Column(name = "colla_interne", nullable = false)
	public boolean isCollaInterne() {
		return this.collaInterne;
	}

	public void setCollaInterne(boolean collaInterne) {
		this.collaInterne = collaInterne;
	}

	@Column(name = "site", length = 512)
	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Column(name = "diplome", nullable = false)
	public String getDiplome() {
		return this.diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formateur")
	public Set<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

}
