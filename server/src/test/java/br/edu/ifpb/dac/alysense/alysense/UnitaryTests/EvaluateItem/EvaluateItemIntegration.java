package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.EvaluateItem;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.business.service.EvalueteItemService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Sample;
import br.edu.ifpb.dac.alysense.alysense.model.repository.EvaluateItemRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.EvalueteItemController;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EvalueteItemDTO;

public class EvaluateItemIntegration {
    
    @InjectMocks
    private EvalueteItemController evalueteItemController;

    @InjectMocks
    private EvalueteItemService evalueteItemService;

    @InjectMocks
    private ConverterService converterService;

    @Mock
    private EvaluateItemRepository evalueteItemRepository;

    @Captor
	private ArgumentCaptor<EvalueteItem> captureEvalueteItem = ArgumentCaptor.forClass(EvalueteItem.class);;

    private EvalueteItem evalueteItem;

    private EvalueteItemDTO evalueteItemDTO;

    private List<EvalueteItemDTO> evalueteItemDTOs;

    private ResponseEntity responseEntity;


   
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        evalueteItemController = new EvalueteItemController();
        evalueteItemService = new EvalueteItemService();
        converterService = new ConverterService();

        ReflectionTestUtils.setField(evalueteItemService, "evalueteItemRepository", evalueteItemRepository);
        ReflectionTestUtils.setField(evalueteItemController, "evalueteItemService", evalueteItemService);
        ReflectionTestUtils.setField(evalueteItemController, "converterService", converterService);


        evalueteItem = new EvalueteItem();
        evalueteItem.setId(1L);
        evalueteItem.setQuestion("TATO");
        evalueteItem.setEvaluator(1L);
        evalueteItem.setSample(new Sample());
        evalueteItem.setNote(new Note());


        evalueteItemDTO = new EvalueteItemDTO();
        evalueteItemDTO.setId(1L);
        evalueteItemDTO.setQuestion("TATO");
        evalueteItemDTO.setEvaluator(1L);
        evalueteItemDTO.setSample(new Sample());
        evalueteItemDTO.setNote(new Note());

        evalueteItemDTOs.add(evalueteItemDTO);

    }

    @Test
    public void saveEvalueteItemDataBase(){
        try {
            responseEntity = evalueteItemController.save(evalueteItemDTOs);
            Mockito.verify(evalueteItemService).save(evalueteItem);
            EvalueteItem evalueteItemData = captureEvalueteItem.getValue();

            assertAll("Test for save EvalueteItem using EvalueteItemDTO",
					() -> assertEquals(evalueteItemDTO.getId(),evalueteItemData.getId()),
					() -> assertEquals(evalueteItemDTO.getQuestion(), evalueteItemData.getQuestion()),
					() -> assertEquals(evalueteItemDTO.getEvaluator(), evalueteItemData.getEvaluator()),
					() -> assertEquals(evalueteItemDTO.getSample(), evalueteItemData.getSample()),
					() -> assertEquals(evalueteItemDTO.getNote(), evalueteItemData.getNote()));

        } catch (Exception e) {
        
        }
    }

    @Test
    public void saveEvalueteItem () {
        try {
			responseEntity = evalueteItemController.save(evalueteItemDTOs);

			assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Test
	public void updateEvalueteItemByIdDataBase() throws Exception {
		try {
			responseEntity = evalueteItemController.update(1L, evalueteItemDTO);
			Mockito.verify(evalueteItemService, Mockito.times(1)).update(captureEvalueteItem.capture());
			EvalueteItem evalueteItemData = captureEvalueteItem.getValue();

			assertEquals(evalueteItemDTO.getId(), evalueteItemData.getId());

		} catch (Exception e) {
			e.getMessage();
		}
	}

    @Test
	public void updateEvalueteItemNotPossible() {

		try {
			responseEntity = evalueteItemController.update(1L, evalueteItemDTO);
			Mockito.when(evalueteItemService.update(evalueteItem)).thenThrow(new Exception());
			String test = String.valueOf(responseEntity.getBody());

			assertAll("Not found Entity", 
					() -> assertTrue(test.contains("Event cannot be updated!")),
					() -> assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode()));

		} catch (Exception e) {
			e.getMessage();
		}

	}

    @Test
	public void updateEvalueteItemHttpStatusOk() {
			try {
				Mockito.when(evalueteItemService.update(Mockito.any())).thenReturn(evalueteItem);
				responseEntity = evalueteItemController.update(evalueteItem.getId(), evalueteItemDTO);
				
				assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}

    @Test
	public void deleteEvalueteItemById() {
		
		try {
			responseEntity = evalueteItemController.delete(1L);
			
			assertAll("Not found Entity",
					() -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
					() -> assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode()),
					() -> assertEquals(null, responseEntity.getBody()));
			
			Mockito.verify(evalueteItemController, Mockito.times(1)).delete(1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
