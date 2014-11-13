package com.SQLI.WZA.model;

// Generated 2 nov. 2014 19:02:33 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Objectif generated by hbm2java
 */
@Entity
@Table(name = "objectif", catalog = "gestionformation")
public class Objectif implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idObjectif;
	private EvaluationFroid evaluationFroid;
	private Formation formation;
	private String intituleOjbectif;

	public Objectif() {
	}

	public Objectif(EvaluationFroid evaluationFroid, Formation formation,
			String intituleOjbectif) {
		this.evaluationFroid = evaluationFroid;
		this.formation = formation;
		this.intituleOjbectif = intituleOjbectif;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_objectif", unique = true, nullable = false)
	public Integer getIdObjectif() {
		return this.idObjectif;
	}

	public void setIdObjectif(Integer idObjectif) {
		this.idObjectif = idObjectif;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evaluation_froid", nullable = false)
	public EvaluationFroid getEvaluationFroid() {
		return this.evaluationFroid;
	}

	public void setEvaluationFroid(EvaluationFroid evaluationFroid) {
		this.evaluationFroid = evaluationFroid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_formation", nullable = false)
	public Formation getFormation() {
		return this.formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Column(name = "intitule_ojbectif", nullable = false)
	public String getIntituleOjbectif() {
		return this.intituleOjbectif;
	}

	public void setIntituleOjbectif(String intituleOjbectif) {
		this.intituleOjbectif = intituleOjbectif;
	}

}