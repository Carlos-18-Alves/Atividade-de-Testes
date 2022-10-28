package br.edu.ifpb.dac.alysense.alysense.model.entity;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Characteristic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String atribute;
    
    public boolean validateAtribute() {      
    	Pattern p = Pattern.compile("^[A-Za-z]*$");
		Matcher m = p.matcher(atribute);
		
		if(m.matches()){
			return true;
		} else {
			setAtribute(null);
			return false;
		}	
    }

	
}
