package com.eperfections.inventory.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        /*return List.of(
                new Product(1,
                        "gasoline chainsaw",
                        100.0,
                        LocalDate.of(2022,02,10),
                        "Lishui senwei industry and trading Co",
                        10)
        );*/
        return productRepository.findAll();
    }


    public void addProduct(Product product) {
        System.out.println(product);
    }
}
