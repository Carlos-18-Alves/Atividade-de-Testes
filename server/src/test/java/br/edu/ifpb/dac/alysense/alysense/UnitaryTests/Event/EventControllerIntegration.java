package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Event;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
import br.edu.ifpb.dac.alysense.alysense.business.service.EventService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EventSense;
import br.edu.ifpb.dac.alysense.alysense.model.repository.EventRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.EventController;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EventDTO;


public class EventControllerIntegration {
    
    @InjectMocks
    private EventController eventController;

    @InjectMocks
    private EventService eventService;

    @InjectMocks
    private ConverterService converterService;

    @Mock
    private EventRepository eventRepository;

    @Captor
	private ArgumentCaptor<EventSense> captureEvent = ArgumentCaptor.forClass(EventSense.class);;

    private EventSense eventSense;

    private EventDTO eventDTO;

    private ResponseEntity responseEntity;


   
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        eventController = new EventController();
        eventService = new EventService();
        converterService = new ConverterService();

        ReflectionTestUtils.setField(eventService, "eventRepository", eventRepository);
        ReflectionTestUtils.setField(eventController, "eventService", eventService);
        ReflectionTestUtils.setField(eventController, "converterService", converterService);


        eventSense = new EventSense();
        eventSense.setId(1L);
        eventSense.setTitle("Copa do Mundo");
        eventSense.setDateEvent(LocalDate.now());
        eventSense.setLocal("Bar");
        eventSense.setPeopleLimit(30);
        eventSense.setNumberSample(45);
        eventSense.setMinimunAge(18);
        eventSense.setEvaluators(null);
        eventSense.setItems(null);
        eventSense.setAdmUser(1L);


        eventDTO = new EventDTO();
        eventDTO.setId(1L);
        eventDTO.setTitle("Copa do Mundo");
        eventDTO.setDateEvent(LocalDate.now());
        eventDTO.setLocal("Bar");
        eventDTO.setPeopleLimit(30);
        eventDTO.setNumberSample(45);
        eventDTO.setMinimunAge(18);
        eventDTO.setEvaluators(null);
        eventDTO.setItems(null);
        eventDTO.setAdmUser(1L);

    }

    @Test
    public void saveEventDataBase(){
        try {
            responseEntity = eventController.save(eventDTO);
            Mockito.verify(eventService).save(eventSense);
            EventSense eventData = captureEvent.getValue();

            assertAll("Test for save EventSense using EventDTO",
					() -> assertEquals(eventDTO.getId(), eventData.getId()),
					() -> assertEquals(eventDTO.getTitle(), eventData.getTitle()),
					() -> assertEquals(eventDTO.getDateEvent(), eventData.getDateEvent()),
					() -> assertEquals(eventDTO.getLocal(), eventData.getLocal()),
					() -> assertEquals(eventDTO.getPeopleLimit(), eventData.getPeopleLimit()),
					() -> assertEquals(eventDTO.getNumberSample(), eventData.getNumberSample()),
					() -> assertEquals(eventDTO.getMinimunAge(), eventData.getMinimunAge()),
					() -> assertEquals(eventDTO.getEvaluators(), eventData.getEvaluators()),
					() -> assertEquals(eventDTO.getItems(), eventData.getItems()),
                    () -> assertEquals(eventDTO.getAdmUser(), eventData.getAdmUser()));

        } catch (Exception e) {
        
        }
    }

    @Test
    public void saveEvent () {
        try {
			responseEntity = eventController.save(eventDTO);

			assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Test
	public void updateEventByIdDataBase() throws Exception {
		try {
			responseEntity = eventController.update(1L, eventDTO);
			Mockito.verify(eventService, Mockito.times(1)).update(captureEvent.capture());
			EventSense eventData = captureEvent.getValue();

			assertEquals(eventDTO.getId(), eventData.getId());

		} catch (Exception e) {
			e.getMessage();
		}
	}

    @Test
	public void updateEventNotPossible() {

		try {
			responseEntity = eventController.update(1L, eventDTO);
			Mockito.when(eventService.update(eventSense)).thenThrow(new Exception());
			String test = String.valueOf(responseEntity.getBody());

			assertAll("Not found Entity", 
					() -> assertTrue(test.contains("Event cannot be updated!")),
					() -> assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode()));

		} catch (Exception e) {
			e.getMessage();
		}

	}

    @Test
	public void updateEventHttpStatusOk() {
			try {
				Mockito.when(eventService.update(Mockito.any())).thenReturn(eventSense);
				responseEntity = eventController.update(eventSense.getId(), eventDTO);
				
				assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}

    @Test
	public void deleteEventById() {
		
		try {
			responseEntity = eventController.delete(1L);
			
			assertAll("Not found Entity",
					() -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
					() -> assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode()),
					() -> assertEquals(null, responseEntity.getBody()));
			
			Mockito.verify(eventController, Mockito.times(1)).delete(1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}




}
