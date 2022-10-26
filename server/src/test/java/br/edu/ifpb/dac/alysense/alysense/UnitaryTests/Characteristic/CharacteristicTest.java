package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Characteristic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;

public class CharacteristicTest {
	
    private Characteristic characteristic = new Characteristic();
    
    public void setName(String characteristic) throws Exception {      
    	Pattern p = Pattern.compile("^(([a-zA-Z ]|[é])*)$");
		Matcher m = p.matcher(characteristic);
		
		if(m.matches()){
			this.characteristic.setAtribute(characteristic);
		} else {
			this.characteristic.setAtribute(null);
			throw new Exception("Invalid input");
		}	
    }
    
    @Test
    void Test() {
    	try {
			setName("Salgado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	assertTrue(this.characteristic!=null);
    }
    
    @ParameterizedTest
	@ValueSource(strings = {"Doce", "Azedo", "Podre", "Aguado", "Insosso"})
	void characteristics(String characteristic) {
    	try {
			setName(characteristic);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertTrue(characteristic!=null);
	}
    

}
