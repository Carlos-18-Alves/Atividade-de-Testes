package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Avaliation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Avaliation;

public class AvaliationTests {
	
	private static Avaliation avaliation = new Avaliation();
	
	@Test
	@DisplayName("Verify if the answer doesn't contain numbers")
	public void succedingTestAnswer ( ){
		
		avaliation.setAnswer("Good");
		assertTrue(avaliation.isValidString(avaliation.getAnswer()));
	}
	
	@ParameterizedTest
	@DisplayName("Verify if many answers don't contain number")
	@ValueSource(strings = {"Very Good", "Bad", "Very Bad", "Horrible", "I don't like", "acessível", 
			"admirável"})
	public void succedingTestsAnswers (String strings) {
		assertTrue(avaliation.isValidString(strings));
	}
	
	@Test
	@DisplayName("Verify if the answer contains numbers")
	public void failingTestAnswer ( ){
		avaliation.setAnswer("Good34");
		assertFalse(avaliation.isValidString(avaliation.getAnswer()));
	}
	
	@ParameterizedTest
	@DisplayName("Verify if many answers contain numbers")
	@ValueSource(strings = {"Very 45", "32425235", "V3ry B4d", "Horr1ble", "1I dont like", "1 2 3 4 5", 
			"h534fsdf123e"})
	public void failingTestsAnswers (String strings) {
		assertFalse(avaliation.isValidString(strings));
	}
	
	@Test
	@DisplayName("Verify if the eventTitle is created ")
	public void succedingTestEventTitle ( ){
		avaliation.setTitleEvent("Japanese Food");
		assertEquals("Japanese Food", avaliation.getTitleEvent());
	}
	
	@ParameterizedTest
	@DisplayName("Verify if many eventTitles are created")
	@ValueSource(strings = {"2 Food Truck", "Mexican Party", "Only Fish", "23 years with chicken" })
	public void succedingTestsEventTitle (String strings) {
		avaliation.setTitleEvent(strings);
		assertEquals(strings, avaliation.getTitleEvent());
	}

}
