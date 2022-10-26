package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.EvaluateItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;

@TestInstance(value = Lifecycle.PER_CLASS)
public class EvaluateItemTests {
	
	private EvalueteItem evalueteItem = new EvalueteItem();
	
	@BeforeAll
	void init() {
		evalueteItem.setQuestion("NAO");
		Note note = new Note();
		note.setScale((float) 5.5);
		evalueteItem.setNote(note);
	}
	
	@Test
	void Test() {
		assertTrue(evalueteItem.getQuestion().equals("NAO"));
		assertEquals(null, evalueteItem.getSample());
		assertEquals(5.5, evalueteItem.getNote().getScale());
	}
	
    
    
}
