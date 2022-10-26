package br.edu.ifpb.dac.alysense.alysense.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class EvalueteItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String question;

	private Long evaluator;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private Sample sample;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private Note note;

	public synchronized Long getId() {
		return id;
	}

	public synchronized void setId(Long id) {
		this.id = id;
	}

	public synchronized String getQuestion() {
		return question;
	}

	public synchronized void setQuestion(String question) {
		this.question = question;
	}

	public synchronized Long getEvaluator() {
		return evaluator;
	}

	public synchronized void setEvaluator(Long evaluator) {
		this.evaluator = evaluator;
	}

	public synchronized Sample getSample() {
		return sample;
	}

	public synchronized void setSample(Sample sample) {
		this.sample = sample;
	}

	public synchronized Note getNote() {
		return note;
	}

	public synchronized void setNote(Note note) {
		this.note = note;
	}
	
	

}
