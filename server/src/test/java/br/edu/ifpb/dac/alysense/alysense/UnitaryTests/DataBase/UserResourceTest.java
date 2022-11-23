package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.DataBase;



import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.UserController;

public class UserResourceTest extends TestDatabase {
    
     private MockMvc mockMvc;
     
     @Autowired
     private UserController userController;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void createUserWithCorrectDatas() throws Exception {
        User user = new User ();
        user.setName("joão");
        user.setEmail("Joao@gmail.com");
        user.setPassword("1234");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json)
        )
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.header().string("location", Matchers.containsString("http://localhost/user")));
    }
}
