package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
@Getter
@Setter
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
	
	public boolean validateQuestion() {      
    	Pattern p = Pattern.compile("^[A-Za-z]*$");
		Matcher m = p.matcher(getQuestion());
		
		if(m.matches()){
			return true;
		} else {
			setQuestion(null);
			return false;
		}	
    }

}
