package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Sample;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {
    private Long id;
    private String title;
    private LocalDate dateEvent;
    private String local;
    private Integer peopleLimit;
    private Integer numberSample;
    private List<UserDTO> evaluators;
    private List<Product> items;
    private Long admUser;
    private Integer minimunAge;
    
}
