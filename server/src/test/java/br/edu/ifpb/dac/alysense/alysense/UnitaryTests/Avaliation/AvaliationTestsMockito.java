package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Avaliation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Avaliation;

@ExtendWith(MockitoExtension.class)
public class AvaliationTestsMockito {
	
	private Avaliation avaliationMock = mock(Avaliation.class);
		
	@BeforeEach
	public void init() {
	    MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void succedingTestAnswer ( ){
		
		when(avaliationMock.isValidString("Good")).thenReturn(true);
		when(avaliationMock.isValidString(null)).thenReturn(false);
		
		assertEquals(true, avaliationMock.isValidString("Good"));
		assertEquals(false, avaliationMock.isValidString(null));
	}
	
	
	
	
}
