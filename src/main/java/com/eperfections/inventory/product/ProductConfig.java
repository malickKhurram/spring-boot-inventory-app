package com.eperfections.inventory.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product product1 = new Product(
                    "gasoline chainsaw",
                    100.0,
                    LocalDate.of(2022,02,10),
                    "Lishui senwei industry and trading Co",
                    10);
            Product product2 = new Product(
                    "gasoline chainsaw 2",
                    100.0,
                    LocalDate.of(2022,02,10),
                    "Lishui senwei industry and trading Co",
                    10);
            repository.saveAll(List.of(product1,product2));
        };
    }
}
