package dev.shreya.productservice.controllers;

import dev.shreya.productservice.dtos.CreateProductRequestDto;
import dev.shreya.productservice.models.Category;
import dev.shreya.productservice.models.Product;
import dev.shreya.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request) {
        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImage()
        );
    }
    @PutMapping("/product/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,@RequestBody CreateProductRequestDto request) {
        return productService.updateProduct(
                productId,
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImage()
        );
    }

    //Type this in URL - http://localhost:8080/products/1
    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId) {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts()  {

        List<Product> products = productService.getProducts();

//        throw new ProductNotFoundException("Bla bla bla");

        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response;
    }
    @GetMapping("/product/categories")
    public List<Category> getAllProductsCategories()  {

        List<Category> categories = productService.getAllProductsCategories();

//        throw new ProductNotFoundException("Bla bla bla");

      //  ResponseEntity<List<String>> response = new ResponseEntity<>(categories, HttpStatus.OK);
        return categories;
    }
    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>> getProductInSpecificCategory(@PathVariable("category") String category)  {

        List<Product> products = productService.getProductInSpecificCategory(category);

//        throw new ProductNotFoundException("Bla bla bla");

        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/product/{id}")
    public Product  deleteProductById(@PathVariable("id") Long productId){
        return productService.deleteProduct(productId);
    }
}
