package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Product.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;




import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import br.edu.ifpb.dac.alysense.alysense.business.service.ProductService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.repository.ProductRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.ProductController;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.ProductDTO;


@SpringBootTest
public class ProductControllerTest {

        @Autowired
        ProductController controller;
    
        @Autowired
        ProductService service;
    
        @Autowired
        ProductRepository repository;
    
        ProductDTO dto;
    
        Product entity;
    
      /*   @BeforeAll
        public void setUp(){
            dto = new ProductDTO();
            entity = new Product();
        } */
    
    
    //    @Test
    //    public void createTest(){
    //        ResponseEntity res = controller.save(dto);
    //        assertEquals(HttpStatus.CREATED, res.getStatusCode());
   //         assertEquals(ProductDTO.class, res.getBody().getClass());
     //   }
        
    
        /*@Test
        public void findTest(){
            service.save(entity);
            EvaluateItemDTO dtoCompare = service.findById(entity.getId());
            assertNull(dtoCompare.getAspectAvaliation());
            assertNull(dtoCompare.getProduct());
            assertEquals(entity.getId(), dtoCompare.getId());
        }
        @Test
        public void findAtributeTest(){
            entity = new EvaluateItem();
            Product product = new Product();
            product.setName("Pizza");
            product.setOwner("qualquer");
            entity.setProduct(product);
            Answer as = new Answer();
            entity.setAspectAvaliation(as);
            service.save(entity);
            EvaluateItemDTO dtoCompare = service.findById(entity.getId());
            assertAll(() -> assertEquals(entity.getProduct().getId(), dtoCompare.getProduct().getId()),() ->
            assertEquals(entity.getProduct().getName(), dtoCompare.getProduct().getName()), ()->
            assertEquals(entity.getProduct().getOwner(), dtoCompare.getProduct().getOwner()), ()-> 
            assertNull(dtoCompare.getProduct().getExpirationDate()));
            assertNotNull(dtoCompare.getAspectAvaliation());
        }
        @Test
        public void updateTest(){
            service.save(entity);
            Product product = new Product();
            product.setName("Pizza");
            entity.setProduct(product);
            service.update(entity);
            EvaluateItemDTO dtoCompore = service.findById(entity.getId());
            assertNotNull(dtoCompore);
            assertEquals(product.getName(), dtoCompore.getProduct().getName());
        }
        @Test
        public void deleteTest(){
            entity = new EvaluateItem();
            service.save(entity);
            ResponseEntity res = controller.delete(entity.getId());
            assertEquals(HttpStatus.NO_CONTENT,res.getStatusCode());
        }
        */
    
}
    
