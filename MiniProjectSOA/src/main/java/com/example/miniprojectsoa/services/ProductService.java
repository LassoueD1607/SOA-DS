package com.example.miniprojectsoa.services;

import com.example.miniprojectsoa.models.Product;
import com.example.miniprojectsoa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        Optional searchProduct = productRepository.findProductByName(product.getName());
        if (!searchProduct.isPresent()){productRepository.save(product);}
        else throw new IllegalStateException("This product already exists");
    }
    public void deleteProduct(Long productId){
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw new IllegalStateException("Product with id "+ productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, Product product) {
        Product newProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product with id "+ productId + " does not exist !!!"));
        if (product.getName() != null && product.getName().length() > 0 && !Objects.equals(newProduct.getName(), product.getName())) {
            newProduct.setName(product.getName());
        }
        if (product.getCategory() != null && product.getCategory().length() > 0 && !Objects.equals(newProduct.getCategory(), product.getCategory())) {
            newProduct.setCategory(product.getCategory());
        }
        if (product.getQuantity() != null && !Objects.equals(newProduct.getQuantity(), product.getQuantity())) {
            newProduct.setQuantity(product.getQuantity());
        }
        if (product.getPrice() != null && !Objects.equals(newProduct.getPrice(), product.getPrice())) {
            newProduct.setPrice(product.getPrice());
        }
    }

    public Optional<Product> getProduitById(Long id) {
        return productRepository.findById(id);
    }
}
