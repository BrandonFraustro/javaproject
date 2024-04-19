package com.champions.javaproject.services;

import com.champions.javaproject.entities.Products;
import com.champions.javaproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    ProductRepository productRepository;

    //Get method
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    //Get method
    public Optional<Products> getProduct(Long idProduct) {
        try {
            return productRepository.findById(idProduct);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    //Post method
    public Products addProduct(Products product) {
        return productRepository.save(product);
    }

    //Delete method
    public boolean deleteProduct(Long idProduct) {
        try {
            productRepository.deleteById(idProduct);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //Put method
    public Products updateProduct(Long id, Products products) {
        Products productFounded = productRepository.findById(id).get();
        productFounded.setName(products.getName());
        productFounded.setPrice(products.getPrice());
        return productRepository.save(productFounded);
    }
}
