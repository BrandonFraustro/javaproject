package com.champions.javaproject.controllers;

import com.champions.javaproject.entities.Products;
import com.champions.javaproject.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @GetMapping("/getAllProducts")
    public List<Products> getProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/getProduct/{idProduct}")
    public Optional<Products> getProductById(@PathVariable Long idProduct) {
        try {
            return productsService.getProduct(idProduct);
        } catch (Exception e) {
            System.out.println("Error" + e);
            return null;
        }

    }

    @PostMapping("/addProduct")
    public Products saveProduct(@RequestBody Products product) {
        return productsService.addProduct(product);
    }

    @DeleteMapping("/deleteProduct/{idProduct}")
    public String deleteProduct(@PathVariable Long idProduct) {
        boolean canBeDeleted = productsService.deleteProduct(idProduct);

        if (canBeDeleted) {
            return "Product with id " + idProduct + " deleted correctly";
        } else {
            return "Error to delete this product";
        }
    }

    @PutMapping("/updateProduct/{idProduct}")
    public Products updateProduct(@PathVariable Long idProduct, @RequestBody Products product) {
        return productsService.updateProduct(idProduct, product);
    }
}
