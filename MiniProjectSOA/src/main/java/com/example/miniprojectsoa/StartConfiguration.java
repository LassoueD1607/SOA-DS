package com.example.miniprojectsoa;

import com.example.miniprojectsoa.models.Product;
import com.example.miniprojectsoa.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StartConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Product product1 = new Product("Lenovo Ideapad","PC",20L,2500F);
            Product product2 = new Product("Samsung Galaxy X","Phone",15L,2000F);
            Product product3 = new Product("GoPro","Camera",10L,1500F);
            Product product4 = new Product("Dell Vostro","PC",20L,1800F);
            Product product5 = new Product("IPhone 13","Phone",10L,3000F);
            Product product6 = new Product("Canon","Camera",5L,1000F);
            productRepository.saveAll(List.of(product1,product2,product3,product4,product5,product6));



        };
    }
}
