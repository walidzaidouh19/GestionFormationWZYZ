package com.sqli.model;

// Generated 13 nov. 2014 19:47:35 by Hibernate Tools 3.4.0.CR1

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
	private Session session;
	private Collaborateur collaborateur;
	private boolean presence;

	public Assiste() {
	}

	public Assiste(AssisteId id, Session session, Collaborateur collaborateur,
			boolean presence) {
		this.id = id;
		this.session = session;
		this.collaborateur = collaborateur;
		this.presence = presence;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idCollaborateur", column = @Column(name = "id_collaborateur", nullable = false)),
			@AttributeOverride(name = "idSession", column = @Column(name = "id_session", nullable = false)) })
	public AssisteId getId() {
		return this.id;
	}

	public void setId(AssisteId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_session", nullable = false, insertable = false, updatable = false)
	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_collaborateur", nullable = false, insertable = false, updatable = false)
	public Collaborateur getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	@Column(name = "presence", nullable = false)
	public boolean isPresence() {
		return this.presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

}
