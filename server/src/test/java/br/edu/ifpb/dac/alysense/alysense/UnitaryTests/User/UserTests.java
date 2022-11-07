package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.User;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Role;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

@TestInstance(Lifecycle.PER_CLASS)
public class UserTests {
  
	private User user = new User();
	private Role role = new Role();
	
	@BeforeEach
	void init() {
		user.setName("Carl_Johnson");
		user.setEmail("cjagaraga@groove.sa.com");
		user.setPassword("Agaragã$1");
		user.setBirthDate(LocalDate.of(1968, 6, 13));
		role.setName("Admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
	}
	
    @Test
    @DisplayName("Verify if all seted atributes are valid")
    void validUserTests() {
    	assertTrue(user.validateName());
    	assertTrue(user.validateEmail());
    	assertTrue(user.validatePassword());
    	assertTrue(user.validateBirthDate());
    	assertNotNull(user.getRoles());
    }
    
    @ParameterizedTest
    @DisplayName("Verify if some names are valid")
	@ValueSource(strings = {"Carlos", "Guilherme", "Tiago", "Iriedson", "Thallyta", "Tarcizo", "Tamires", "Janmbo", "Debora", "Eliana"})
	void validNames(String name) {
		user.setName(name);
		assertTrue(user.validateName());
	}
    
    @ParameterizedTest
    @DisplayName("Verify if some names are invalid")
	@ValueSource(strings = {"Carlos%", "Gui\\herme", "T&ago", "Iried$on", "T#allyta", "Tarcizo¨", "T@mires", "Jan", "Débora", "Eliana*"})
	void invalidNames(String name) {
		user.setName(name);
		assertFalse(user.validateName());
	} 
    
    @ParameterizedTest
    @DisplayName("Verify if some emails are valid")
	@ValueSource(strings = {"ryder@groove.sa.com", "person@gmail.com.br", "south@maps.wow.en", "blue@color.ok.bl", "myself@ifpb.edu.br"})
	void validEmails(String email) {
		user.setEmail(email);
		assertTrue(user.validateEmail());
	}
    
    @ParameterizedTest
    @DisplayName("Verify if some emails are invalid")
	@ValueSource(strings = {"ryder@sa.com", "person@gmail.br", "south.maps.wow.en", "blue#color.ok.bl", "myself@ifpb.br"})
	void invalidEmails(String email) {
		user.setEmail(email);
		assertFalse(user.validateEmail());
	}
    
    @ParameterizedTest
    @DisplayName("Verify if some passwords are valid")
	@ValueSource(strings = {"Lula#13kk", "100senHa$", "@Naodigo11&", "Aham123$", "Seina1#@"})
	void validPasswords(String senha) {
		user.setPassword(senha);
		assertTrue(user.validatePassword());
	}
    
    @ParameterizedTest
    @DisplayName("Verify if some passwords are invalid")
	@ValueSource(strings = {"lula13", "100senha", "Naodigo", "123$456#", "Seina1"})
	void invalidPasswords(String senha) {
		user.setPassword(senha);
		assertFalse(user.validatePassword());
	}
    
    @ParameterizedTest
    @DisplayName("Verify if some birthdates are valid")
	@ValueSource(ints = {2012, 1970, 2000, 2010, 1990, 2005, 1978})
	void validBirthDates(int year) {
    	LocalDate date1 = LocalDate.of(year, 4, 12);
		user.setBirthDate(date1);
		assertTrue(user.validateBirthDate());
	}
    
    @ParameterizedTest
    @DisplayName("Verify if some birthdates are invalid")
	@ValueSource(ints = {2013, 2017, 2022, 2028, 2100, 2020, 3000})
	void invalidBirthDates(int year) {
    	LocalDate date1 = LocalDate.of(year, 4, 12);
		user.setBirthDate(date1);
		assertFalse(user.validateBirthDate());
	}
    
}
