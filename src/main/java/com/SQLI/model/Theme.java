package com.sqli.model;

// Generated 15 nov. 2014 14:53:03 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Theme generated by hbm2java
 */
@Entity
@Table(name = "theme", catalog = "gestionformation")
public class Theme implements java.io.Serializable {

	private Integer idTheme;
	private String intitule;
	private String domaine;

	public Theme() {
	}

	public Theme(String intitule, String domaine) {
		this.intitule = intitule;
		this.domaine = domaine;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_theme", unique = true, nullable = false)
	public Integer getIdTheme() {
		return this.idTheme;
	}

	public void setIdTheme(Integer idTheme) {
		this.idTheme = idTheme;
	}

	@Column(name = "intitule", nullable = false)
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Column(name = "domaine", nullable = false)
	public String getDomaine() {
		return this.domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

}
