package com.SQLI.WZA.model;

// Generated 2 nov. 2014 19:02:33 by Hibernate Tools 4.0.0

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
 * Reponse generated by hbm2java
 */
@Entity
@Table(name = "reponse", catalog = "gestionformation")
public class Reponse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReponseId id;
	private EvaluationChaud evaluationChaud;
	private Question question;
	private int valeur;

	public Reponse() {
	}

	public Reponse(ReponseId id, EvaluationChaud evaluationChaud,
			Question question, int valeur) {
		this.id = id;
		this.evaluationChaud = evaluationChaud;
		this.question = question;
		this.valeur = valeur;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idEvaluationChaud", column = @Column(name = "id_evaluation_chaud", nullable = false)),
			@AttributeOverride(name = "idQuestion", column = @Column(name = "id_question", nullable = false)) })
	public ReponseId getId() {
		return this.id;
	}

	public void setId(ReponseId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evaluation_chaud", nullable = false, insertable = false, updatable = false)
	public EvaluationChaud getEvaluationChaud() {
		return this.evaluationChaud;
	}

	public void setEvaluationChaud(EvaluationChaud evaluationChaud) {
		this.evaluationChaud = evaluationChaud;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question", nullable = false, insertable = false, updatable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "valeur", nullable = false)
	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
