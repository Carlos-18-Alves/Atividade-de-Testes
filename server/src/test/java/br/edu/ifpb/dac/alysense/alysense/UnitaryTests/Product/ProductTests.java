package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;

@TestInstance(value = Lifecycle.PER_CLASS)
public class ProductTests {

	Product product = new Product();
	
	@BeforeAll
	void init() {
		product.setName("Sopa");
		product.setExpirationDate(LocalDate.of(2023, 04, 11));
		product.setIngredients("macarrão, água, sal, legumes, carne");
		product.setOwner("Dona Tia");
	}
	
	@Test
	void test()	{
		assertEquals(product.getName(), "Sopa");
		assertTrue(product.getSamples()==null);
		assertEquals(product, product);
	}
	
}
