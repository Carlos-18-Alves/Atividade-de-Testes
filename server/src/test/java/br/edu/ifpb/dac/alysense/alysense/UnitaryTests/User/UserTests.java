package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.User;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.dac.alysense.alysense.business.service.ValidationAgeUserService;

public class UserTests {
  

    @Test
    @DisplayName("Age should be higher than")
    public void UserAge() {
        LocalDate birthDate = LocalDate.now().minusYears(19);

        assertEquals(true, ValidationAgeUserService.isAgeEnoughToVote(19, birthDate.minusMonths(1)));
        assertEquals(true, ValidationAgeUserService.isAgeEnoughToVote(19, birthDate));
        assertEquals(false, ValidationAgeUserService.isAgeEnoughToVote(19, birthDate.plusMonths(1)));
    }
    
}
