package dev.shreya.productservice;

import dev.shreya.productservice.models.Category;
import dev.shreya.productservice.repositories.ProductRepository;
import dev.shreya.productservice.repositories.projections.ProductWithIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductserviceApplicationTests {
 @Autowired
    ProductRepository productRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void productRepoTest(){
       List<ProductWithIdAndTitle>  productWithIdAndTitles= productRepository.getNameOfProductWithProjection("t2", 2L);
         //();
       System.out.println(productWithIdAndTitles.get(0).getTitle());
       //Native
       List<ProductWithIdAndTitle>  productWithIdAndTitles1= productRepository.getNameOfProductWithProjection("t2", 2L);
       //();
       System.out.println(productWithIdAndTitles1.get(0).getTitle());
    }

}
