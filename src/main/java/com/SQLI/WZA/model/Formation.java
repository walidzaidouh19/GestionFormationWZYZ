package com.SQLI.WZA.model;

// Generated 2 nov. 2014 19:02:33 by Hibernate Tools 4.0.0

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Formation generated by hbm2java
 */
@Entity
@Table(name = "formation", catalog = "gestionformation")
public class Formation implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idFormation;
	private String intitule;
	private int duree;
	private Date datePrevuRealisation;
	private Date dateButoire;
	private boolean realise;
	private int idTheme;
	private Set<Objectif> objectifs = new HashSet<Objectif>(0);
	private Set<Session> sessions = new HashSet<Session>(0);

	public Formation() {
	}

	public Formation(String intitule, int duree, Date datePrevuRealisation,
			Date dateButoire, boolean realise, int idTheme) {
		this.intitule = intitule;
		this.duree = duree;
		this.datePrevuRealisation = datePrevuRealisation;
		this.dateButoire = dateButoire;
		this.realise = realise;
		this.idTheme = idTheme;
	}

	public Formation(String intitule, int duree, Date datePrevuRealisation,
			Date dateButoire, boolean realise, int idTheme,
			Set<Objectif> objectifs, Set<Session> sessions) {
		this.intitule = intitule;
		this.duree = duree;
		this.datePrevuRealisation = datePrevuRealisation;
		this.dateButoire = dateButoire;
		this.realise = realise;
		this.idTheme = idTheme;
		this.objectifs = objectifs;
		this.sessions = sessions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_formation", unique = true, nullable = false)
	public Integer getIdFormation() {
		return this.idFormation;
	}

	public void setIdFormation(Integer idFormation) {
		this.idFormation = idFormation;
	}

	@Column(name = "intitule", nullable = false)
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Column(name = "duree", nullable = false)
	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_prevu_realisation", nullable = false, length = 10)
	public Date getDatePrevuRealisation() {
		return this.datePrevuRealisation;
	}

	public void setDatePrevuRealisation(Date datePrevuRealisation) {
		this.datePrevuRealisation = datePrevuRealisation;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_butoire", nullable = false, length = 10)
	public Date getDateButoire() {
		return this.dateButoire;
	}

	public void setDateButoire(Date dateButoire) {
		this.dateButoire = dateButoire;
	}

	@Column(name = "realise", nullable = false)
	public boolean isRealise() {
		return this.realise;
	}

	public void setRealise(boolean realise) {
		this.realise = realise;
	}

	@Column(name = "id_theme", nullable = false)
	public int getIdTheme() {
		return this.idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formation")
	public Set<Objectif> getObjectifs() {
		return this.objectifs;
	}

	public void setObjectifs(Set<Objectif> objectifs) {
		this.objectifs = objectifs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formation")
	public Set<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

}
