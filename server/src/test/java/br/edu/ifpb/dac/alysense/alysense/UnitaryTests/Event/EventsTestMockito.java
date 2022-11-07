package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Event;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EventSense;

@ExtendWith(MockitoExtension.class)
public class EventsTestMockito {

	@Mock
	EventSense eventSenseMock;
	
	@Test
	void mockEventLocal() {
		when(eventSenseMock.getLocal()).thenReturn("Quadra");
		assertNotNull(eventSenseMock.getLocal());
		
		when(eventSenseMock.getLocal()).thenReturn("Quadra IFPB");
		assertTrue(eventSenseMock.getLocal().contains(" "));
		
		when(eventSenseMock.getLocal()).thenReturn("Piscina");
		assertEquals("Piscina", eventSenseMock.getLocal());
		
		verify(eventSenseMock, times(3)).getLocal();
	}
	
	
	@Test
	void mockEventAge() {
		when(eventSenseMock.getMinimunAge()).thenReturn(34);
		assertNotNull(eventSenseMock.getMinimunAge());
		
		when(eventSenseMock.getMinimunAge()).thenReturn(16);
		assertFalse(eventSenseMock.isValidAge(eventSenseMock.getMinimunAge()));
		
		when(eventSenseMock.getMinimunAge()).thenReturn(18);
		assertEquals(18, eventSenseMock.getMinimunAge());
		
		verify(eventSenseMock, times(3)).getMinimunAge();
	}
	
	
	@Test
	void mockEventLimitPeople() {
		when(eventSenseMock.getPeopleLimit()).thenReturn(34);
		assertNotNull(eventSenseMock.getPeopleLimit());
					
		when(eventSenseMock.getPeopleLimit()).thenReturn(18);
		assertEquals(18, eventSenseMock.getPeopleLimit());
		
		verify(eventSenseMock, times(2)).getPeopleLimit();
	}


	
}
