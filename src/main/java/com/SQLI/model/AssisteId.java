package com.sqli.model;

// Generated 15 nov. 2014 14:53:03 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AssisteId generated by hbm2java
 */
@Embeddable
public class AssisteId implements java.io.Serializable {

	private String matricule;
	private int idSession;

	public AssisteId() {
	}

	public AssisteId(String matricule, int idSession) {
		this.matricule = matricule;
		this.idSession = idSession;
	}

	@Column(name = "matricule", nullable = false, length = 50)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Column(name = "id_session", nullable = false)
	public int getIdSession() {
		return this.idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AssisteId))
			return false;
		AssisteId castOther = (AssisteId) other;

		return ((this.getMatricule() == castOther.getMatricule()) || (this
				.getMatricule() != null && castOther.getMatricule() != null && this
				.getMatricule().equals(castOther.getMatricule())))
				&& (this.getIdSession() == castOther.getIdSession());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMatricule() == null ? 0 : this.getMatricule().hashCode());
		result = 37 * result + this.getIdSession();
		return result;
	}

}
