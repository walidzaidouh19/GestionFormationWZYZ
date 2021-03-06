package com.sqli.model;

// Generated 15 nov. 2014 14:53:03 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Assiste generated by hbm2java
 */
@Entity
@Table(name = "assiste", catalog = "gestionformation")
public class Assiste implements java.io.Serializable {

	private AssisteId id;
	private Personnel personnel;
	private SessionF sessionF;
	private boolean presence;

	public Assiste() {
	}

	public Assiste(AssisteId id, Personnel personnel, SessionF sessionF,
			boolean presence) {
		this.id = id;
		this.personnel = personnel;
		this.sessionF = sessionF;
		this.presence = presence;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "matricule", column = @Column(name = "matricule", nullable = false, length = 50)),
			@AttributeOverride(name = "idSession", column = @Column(name = "id_session", nullable = false)) })
	public AssisteId getId() {
		return this.id;
	}

	public void setId(AssisteId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricule", nullable = false, insertable = false, updatable = false)
	public Personnel getPersonnel() {
		return this.personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_session", nullable = false, insertable = false, updatable = false)
	public SessionF getSessionF() {
		return this.sessionF;
	}

	public void setSessionF(SessionF sessionF) {
		this.sessionF = sessionF;
	}

	@Column(name = "presence", nullable = false)
	public boolean isPresence() {
		return this.presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

}
