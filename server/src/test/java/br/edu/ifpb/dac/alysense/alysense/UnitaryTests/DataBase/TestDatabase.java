package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.DataBase;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import br.edu.ifpb.dac.alysense.alysense.AlysenseApplication;



@SpringBootTest(classes = AlysenseApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class TestDatabase {
    
}
