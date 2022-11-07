package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

@ExtendWith(MockitoExtension.class)
public class UserTestsMockito {
	
	@Mock
	User userMock;
	
	@Test
	void mockUserName() {
		when(userMock.getName()).thenReturn("João");
		assertNotNull(userMock.getName());
		
		when(userMock.getName()).thenReturn("João Silva");
		assertTrue(userMock.getName().contains(" "));
		
		when(userMock.getName()).thenReturn("Pessoa");
		assertEquals("Pessoa", userMock.getName());
		
		verify(userMock, times(3)).getName();
	}
	
	@Test
	void mockUserBirth() {
		when(userMock.getBirthDate()).thenReturn(LocalDate.now());
		assertNotNull(userMock.getBirthDate());
		
		when(userMock.getBirthDate()).thenReturn(LocalDate.now().minusYears(22));
		assertTrue(userMock.getBirthDate().getYear()==2000);
		
		when(userMock.getBirthDate()).thenReturn(LocalDate.now().minusMonths(12));
		assertEquals(2021, userMock.getBirthDate().getYear());
		
		verify(userMock, atLeast(2)).getBirthDate();
	}
	
	@Test
	void mockUserEmail() {
		when(userMock.getEmail()).thenReturn("");
		assertNotNull(userMock.getEmail());
		assertFalse(userMock.validateEmail());
		
		
		when(userMock.getEmail()).thenReturn("pessoa@ifpb.edu.br");
		assertTrue(userMock.getEmail().contains("@"));
		
		when(userMock.getEmail()).thenReturn("ifpb@ifpb.edu.br");
		assertEquals("ifpb@ifpb.edu.br", userMock.getEmail());
		
		verify(userMock, atLeastOnce()).validateEmail();
		verify(userMock, atLeast(3)).getEmail();
	}
	
	@Test
	void mockUserPassword() {
		when(userMock.getPassword()).thenReturn("123");
		assertNotNull(userMock.getPassword());
		assertFalse(userMock.validatePassword());
		
		when(userMock.getPassword()).thenReturn("@123Abcd#");
		assertTrue(userMock.getPassword().contains("123"));
		
		when(userMock.getPassword()).thenReturn("qwe123");
		assertEquals("qwe123", userMock.getPassword());
		
		verify(userMock, atLeastOnce()).validatePassword();
		verify(userMock, times(3)).getPassword();
	}
	
}
