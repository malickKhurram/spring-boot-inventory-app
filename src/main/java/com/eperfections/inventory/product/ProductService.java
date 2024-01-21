package com.eperfections.inventory.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByProductName(product.getProductName());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Product Name already exists.");
        }
        productRepository.save(product);
    }
    public void deleteProduct(Long id){
        boolean exists = productRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "Product with id "+id+" does not exists!"
            );
        }
        productRepository.deleteById(id);
    }
    @Transactional
    public void updateProduct(Long productId, String productName,double price){
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("Product does not exists"));
        if(productName != null &&
            productName.length()>0&&
            !Objects.equals(product.getProductName(),productName)){
            product.setProductName(productName);
        }

        if(price > 0.0){
           product.setPrice(price);
        }
    }
}
