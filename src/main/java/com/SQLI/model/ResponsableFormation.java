package com.sqli.model;

// Generated 15 nov. 2014 14:53:03 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ResponsableFormation generated by hbm2java
 */
@Entity
@Table(name = "responsable_formation", catalog = "gestionformation")
public class ResponsableFormation implements java.io.Serializable {

	private String matricule;
	private Personnel personnel;

	public ResponsableFormation() {
	}

	public ResponsableFormation(String matricule, Personnel personnel) {
		this.matricule = matricule;
		this.personnel = personnel;
	}

	@Id
	@Column(name = "matricule", nullable = false, length = 50)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricule", nullable = false, insertable = false, updatable = false)
	public Personnel getPersonnel() {
		return this.personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

}
