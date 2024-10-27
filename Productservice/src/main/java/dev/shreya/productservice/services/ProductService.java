package dev.shreya.productservice.services;

import dev.shreya.productservice.models.Category;
import dev.shreya.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getProducts();
    List<Category> getAllProductsCategories();
    List<Product> getProductInSpecificCategory(String category);
    Product createProduct(String title,
                          String description,
                          String category,
                          double price,
                          String image);
    Product updateProduct(Long productId,String title,
                          String description,
                          String category,
                          double price,
                          String image);
    Product deleteProduct(Long productId);
}
