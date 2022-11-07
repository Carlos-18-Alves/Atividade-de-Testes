package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.EvaluateItem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;

@ExtendWith(MockitoExtension.class)
public class EvalueteItemTestsMockito {
	
	@Mock
	EvalueteItem evalueteItemMock;
	
	@Spy
	EvalueteItem evalueteItemSpy;
	
	@Spy
	Note noteSpy;
	
	@Test
	void mockItemQuestion() {
		when(evalueteItemMock.getQuestion()).thenReturn("Awesome");
		assertFalse(evalueteItemMock.validateQuestion());
		assertEquals("Awesome",evalueteItemMock.getQuestion());

		verify(evalueteItemMock, times(1)).getQuestion();
	}
	
	@Test
	void spyItemQuestion() {
		when(evalueteItemSpy.getQuestion()).thenReturn("Awesome");
		assertTrue(evalueteItemSpy.validateQuestion());
		assertEquals("Awesome",evalueteItemSpy.getQuestion());
		
		verify(evalueteItemSpy, times(2)).getQuestion();
	}
	
	@Test
	void mockItemNote() {
		when(noteSpy.getScale()).thenReturn(9.9f);
		assertTrue(noteSpy.validateScale());
		when(evalueteItemMock.getNote()).thenReturn(noteSpy);
		assertEquals(9.9f, evalueteItemMock.getNote().getScale());
		
		verify(evalueteItemMock, atLeastOnce()).getNote();
		verify(noteSpy, times(1)).getScale();
	}	
	
	@Test
	void interactions() {
		verifyNoInteractions(evalueteItemSpy,noteSpy);
	}
	
}
