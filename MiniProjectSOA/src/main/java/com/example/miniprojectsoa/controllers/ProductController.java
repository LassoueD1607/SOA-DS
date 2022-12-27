package com.example.miniprojectsoa.controllers;

import com.example.miniprojectsoa.models.Product;
import com.example.miniprojectsoa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("{id}")
    public Optional<Product> getProductById(@PathVariable  Long id){
        return productService.getProduitById(id);
    }
    @PostMapping()
    public void addProduct(@RequestBody Product product){
         productService.addProduct(product);
    }
    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
    @PutMapping("{productId}")
    public void updateProduct(@PathVariable Long productId,@RequestBody Product product){
        productService.updateProduct(productId,product);
    }
}
