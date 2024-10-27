package dev.shreya.productservice.services;

import dev.shreya.productservice.dtos.FakeStoreProductDto;
import dev.shreya.productservice.models.Category;
import dev.shreya.productservice.models.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreProductService implements  ProductService{

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductResponse = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );
        return fakeStoreProductResponse.getBody().toProduct();
    }

    @Override
    public List<Product> getProducts() {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProducts =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProduct: fakeStoreProducts.getBody()) {
            products.add(fakeStoreProduct.toProduct());
        }

        return products;
    }

    @Override
    public List<Category> getAllProductsCategories() {
        ResponseEntity<Category[]> fakeStoreProductsCategories =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products",
                        Category[].class
                );
        List<Category> categoryList = new ArrayList<>();

        for (Category category: fakeStoreProductsCategories.getBody()) {
            categoryList.add(category);
        }

        return categoryList;
    }

    @Override
    public List<Product> getProductInSpecificCategory(String category) {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProducts =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/category/" + category,
                        FakeStoreProductDto[].class
                );

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProduct: fakeStoreProducts.getBody()) {
            products.add(fakeStoreProduct.toProduct());
        }

        return products;
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setDescription(description);

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products", // url
                fakeStoreProductDto, // request body
                FakeStoreProductDto.class // data type of response
        );

        if (response == null) return new Product();

        return response.toProduct();
    }

    @Override
    public Product updateProduct(Long productId,String title, String description, String category, double price, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setDescription(description);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(
                MediaType.APPLICATION_JSON));

        // building a HttpEntity using HttpHeaders and updated
        // customer object to customize the request
        HttpEntity<FakeStoreProductDto> entity
                = new HttpEntity<>(fakeStoreProductDto, httpHeaders);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(
                "https://fakestoreapi.com/products/"+productId ,//URL

                HttpMethod.PUT,
                entity, // request body
                FakeStoreProductDto.class // data type of response
        );

        if (response == null) return new Product();

        return response.getBody().toProduct();
    }
    @Override
    public Product deleteProduct(Long productId) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(
                MediaType.APPLICATION_JSON));

        // building a HttpEntity using HttpHeaders and updated
        // customer object to customize the request
        HttpEntity<FakeStoreProductDto> entity
                = new HttpEntity<>(httpHeaders);
       return restTemplate.exchange(
                "https://fakestoreapi.com/products/"+productId ,//URL

                HttpMethod.DELETE,
                entity, // request body
                FakeStoreProductDto.class // data type of response
        ).getBody().toProduct();


    }
}
