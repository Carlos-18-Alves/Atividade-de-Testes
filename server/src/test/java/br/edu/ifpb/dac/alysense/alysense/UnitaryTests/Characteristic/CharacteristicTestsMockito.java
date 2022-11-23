package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Characteristic;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;

@ExtendWith(MockitoExtension.class)
public class CharacteristicTestsMockito {
	
	@Mock
	Characteristic characteristicMock;
	
	@Test
	void mockCharac() {
		when(characteristicMock.validateAtribute()).thenReturn(true);
		assertTrue(characteristicMock.validateAtribute());
		
		verify(characteristicMock, times(0)).getAtribute();
		verify(characteristicMock, atLeastOnce()).validateAtribute();
	}

}
