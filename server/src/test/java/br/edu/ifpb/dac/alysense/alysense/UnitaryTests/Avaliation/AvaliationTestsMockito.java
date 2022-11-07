package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Avaliation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Avaliation;

@RunWith(MockitoJUnitRunner.class)
public class AvaliationTestsMockito {

	
	private Avaliation avaliationMock = mock(Avaliation.class);
	
		
	@Before
	public void init() {
	    MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("Verify if the answer doesn't contain numbers")
	public void succedingTestAnswer ( ){
		
		when(avaliationMock.isValidString("Good")).thenReturn(true);
		when(avaliationMock.isValidString(null)).thenReturn(false);
		
		assertEquals(true, avaliationMock.isValidString("Good"));
		assertEquals(false, avaliationMock.isValidString(null));
	}
	
	
	
	
}
