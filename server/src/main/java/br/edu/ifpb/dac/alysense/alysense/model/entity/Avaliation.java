package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Avaliation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String answer;
    
    private String titleEvent;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvalueteItem> evalueteItems;

	public synchronized Long getId() {
		return id;
	}

	public synchronized void setId(Long id) {
		this.id = id;
	}

	public synchronized String getAnswer() {
		return answer;
	}

	public synchronized void setAnswer(String answer) {
		this.answer = answer;
	}

	public synchronized String getTitleEvent() {
		return titleEvent;
	}

	public synchronized void setTitleEvent(String titleEvent) {
		this.titleEvent = titleEvent;
	}

	public synchronized List<EvalueteItem> getEvalueteItems() {
		return evalueteItems;
	}

	public synchronized void setEvalueteItems(List<EvalueteItem> evalueteItems) {
		this.evalueteItems = evalueteItems;
	}
    
}