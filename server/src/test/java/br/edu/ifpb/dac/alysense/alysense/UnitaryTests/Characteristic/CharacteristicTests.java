package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Characteristic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;

public class CharacteristicTests {
	
    private Characteristic characteristic = new Characteristic();
    
    @Test
    @DisplayName("Verify if the atribute is saved and is valid")
    void succedingTests() {
		characteristic.setAtribute("Salty");
    	assertTrue(this.characteristic.getAtribute()!=null);
    	assertTrue(characteristic.validateAtribute());
    }
    
    @ParameterizedTest
    @DisplayName("Verify if some atributes are valid")
	@ValueSource(strings = {"Sweet", "Sour", "Rotten", "Watery", "Tasteless", "Burned"})
	void validChar(String characteristic) {
		this.characteristic.setAtribute(characteristic);
		assertTrue(this.characteristic.validateAtribute());
	}
    
	@Test
	@DisplayName("Verify if the atribute is invalid and if it was set null")
	public void failingTests(){
		characteristic.setAtribute("M@ssa Dema&s");
		assertFalse(characteristic.validateAtribute());
		assertNull(characteristic.getAtribute());
	}
	
	@ParameterizedTest
	@DisplayName("Verify if some atributes are invalid")
	@ValueSource(strings = {"Sweet#", "CJ..", "Big $moke", "Cas21", "Kleito$", "1real"})
	void invalidChar(String characteristic) {
		this.characteristic.setAtribute(characteristic);
		assertFalse(this.characteristic.validateAtribute());
	}
    
	@ParameterizedTest
	@DisplayName("Verify if some atributes are saved")
	@ValueSource(strings = {"Tasty", "Sugar Crush", "Delicious", "Candy" })
	public void suceedingAtributes(String strings) {
		characteristic.setAtribute(strings);
		assertEquals(strings, characteristic.getAtribute());
	}

}
