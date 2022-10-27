package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Avaliation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String answer;
    
    private String titleEvent;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvalueteItem> evalueteItems;
    
    
    public boolean isValidString(String name) {
    	for (int i = 0; i < name.length(); i++) {
			char indexName = name.charAt(i);
    		if(Character.isDigit(indexName) == true) {
				return false;
			}
		}
    	return true;
    }
    
}