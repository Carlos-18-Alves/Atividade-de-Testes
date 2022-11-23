package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EventSense;

@TestInstance(value = Lifecycle.PER_CLASS)
public class EventsTests {
    
	EventSense eventSense = new EventSense();
    
	@BeforeAll
	void init() {
		eventSense.setDateEvent(LocalDate.now()); 
		eventSense.setLocal("Quadra");
		eventSense.setMinimunAge(18);
		eventSense.setPeopleLimit(30);
	}
	
	@Test
	void test() {
		assertEquals(eventSense.getDateEvent(), LocalDate.now());
		assertNull(eventSense.getAdmUser());
		assertEquals(eventSense.getMinimunAge(), 18);
		assertEquals(eventSense.getPeopleLimit(), 30);
		
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 15, 14, 8, 0, -1 })
	public void failingTestsAnswers(int ints) {
		assertFalse(eventSense.isValidAge(ints));
	}

	@ParameterizedTest
	@ValueSource(ints = { 18, 35, 40, 56, 222, 100 })
	public void sucessingTestsAnswers(int ints) {
		assertTrue(eventSense.isValidAge(ints));
	}
		
		
	
	
}
