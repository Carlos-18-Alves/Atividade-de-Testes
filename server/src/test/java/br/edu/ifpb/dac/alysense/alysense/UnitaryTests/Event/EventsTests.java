package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

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
	
}
