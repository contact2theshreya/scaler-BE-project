package dev.shreya.productservice;

import dev.shreya.productservice.models.Category;
import dev.shreya.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductserviceApplicationTests {
 @Autowired
    ProductRepository productRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void productRepoTest(){
         //();
    }

}
