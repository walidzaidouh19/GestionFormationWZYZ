package com.sqli.model;

// Generated 15 nov. 2014 14:53:03 by Hibernate Tools 3.4.0.CR1

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

import org.hibernate.annotations.Proxy;

/**
 * Profil generated by hbm2java
 */
@Proxy(lazy=false)
@Entity
@Table(name = "profil", catalog = "gestionformation")
public class Profil implements java.io.Serializable {

	private Integer idProfil;
	private String intituleProfil;
	private Set<Action> actions = new HashSet<Action>(0);
	private Set<Compte> comptes = new HashSet<Compte>(0);

	public Profil() {
	}

	public Profil(String intituleProfil) {
		this.intituleProfil = intituleProfil;
	}

	public Profil(String intituleProfil, Set<Action> actions, Set<Compte> comptes) {
		this.intituleProfil = intituleProfil;
		this.actions = actions;
		this.comptes = comptes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_profil", unique = true, nullable = false)
	public Integer getIdProfil() {
		return this.idProfil;
	}

	public void setIdProfil(Integer idProfil) {
		this.idProfil = idProfil;
	}

	@Column(name = "intitule_profil", nullable = false)
	public String getIntituleProfil() {
		return this.intituleProfil;
	}

	public void setIntituleProfil(String intituleProfil) {
		this.intituleProfil = intituleProfil;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profil")
	public Set<Action> getActions() {
		return this.actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profil")
	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
