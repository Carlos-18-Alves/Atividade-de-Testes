package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Sample;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO {
    private String token;
    private UserDTO user;
    public TokenDTO(String token, UserDTO userDTO) {
        this.token = token;
        this.user = userDTO;
    }
    public TokenDTO() {
    }
    
}