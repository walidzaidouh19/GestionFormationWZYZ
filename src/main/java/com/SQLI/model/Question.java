package com.sqli.model;

// Generated 13 nov. 2014 19:47:35 by Hibernate Tools 3.4.0.CR1

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
 * Question generated by hbm2java
 */
@Entity
@Table(name = "question", catalog = "gestionformation")
public class Question implements java.io.Serializable {

	private Integer idQuestion;
	private String intitule;
	private Set reponses = new HashSet(0);

	public Question() {
	}

	public Question(String intitule) {
		this.intitule = intitule;
	}

	public Question(String intitule, Set reponses) {
		this.intitule = intitule;
		this.reponses = reponses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_question", unique = true, nullable = false)
	public Integer getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}

	@Column(name = "intitule", nullable = false, length = 512)
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	public Set getReponses() {
		return this.reponses;
	}

	public void setReponses(Set reponses) {
		this.reponses = reponses;
	}

}
