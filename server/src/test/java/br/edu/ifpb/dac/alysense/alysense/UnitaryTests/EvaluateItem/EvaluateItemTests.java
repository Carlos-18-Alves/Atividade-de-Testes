package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.EvaluateItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Sample;

@TestInstance(Lifecycle.PER_CLASS)
public class EvaluateItemTests {
	
	private EvalueteItem evalueteItem = new EvalueteItem();
	private Sample sample = new Sample();
	private Note note = new Note();
	
	@BeforeAll
	void init() {
		evalueteItem.setQuestion("Good");
		note.setScale((float) 9.5);
		sample.setDetailsSample("Soup");
	}
	
	@Test
	@Order(1)
	@DisplayName("Verify all atributes from the class EvalueteItem")
	void succedingEvalueteItemTests() {
		assertTrue(evalueteItem.getQuestion().equals("Good"));
		assertTrue(evalueteItem.validateQuestion());
		evalueteItem.setSample(sample);
		assertEquals(sample, evalueteItem.getSample());
		evalueteItem.setNote(note);;
		assertEquals(note, evalueteItem.getNote());
		assertEquals(null, evalueteItem.getEvaluator());
	}
	
	@Test
	@Order(2)
	@DisplayName("Verify if the new sample created is different from the previous")
	void succedingNoteTest() {
		assertTrue(note.validateScale());
	}
	
	@Test
	@Order(3)
	@DisplayName("Verify if the note scale is valid")
	void succedingSampleTest() {
		Sample sample2 = new Sample();
		assertTrue(sample.getCode()!=sample2.getCode());
	}
	
	@ParameterizedTest
	@Order(4)
	@DisplayName("Verify if some note scales are valid")
	@ValueSource(floats = {0, 1.6f, 9.9f, 5.5f, 2.1f, 10})
	void validScales(float scale) {
		this.note.setScale(scale);
		assertTrue(this.note.validateScale());
	}
	
	@ParameterizedTest
	@Order(5)
	@DisplayName("Verify if some note scales are invalid")
	@ValueSource(floats = {-0.1f, -4, 10.1f, 14.2f, 200, -1})
	void invalidScales(float scale) {
		this.note.setScale(scale);
		assertFalse(this.note.validateScale());
	}
	
}
