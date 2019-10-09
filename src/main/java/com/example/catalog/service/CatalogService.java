package com.example.catalog.service;

import com.example.catalog.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.catalog.entity.Product;
import java.util.Optional;
import java.util.ArrayList;


@Service
public class CatalogService {

    private Logger logger = LoggerFactory.getLogger(CatalogService.class);

    @Autowired
    private ProductRepository productRepository;

    public long addProduct(Product product){
        productRepository.save(product);
        return  product.getId();
    }
    public long deleteProduct(long productId)
    {
        Optional<Product> isAvailable =  productRepository.findById(productId);
        if (isAvailable.isPresent()) {
            productRepository.deleteById(productId);
            return productId;
        }else {
            logger.debug("No product found to delete with ProductId  :>>"+productId);
            return -1;
        }
    }
    public ArrayList<Product> getAllProducts(){
            return (ArrayList<Product>) productRepository.findAll();
    }
}
