package org.example.atelier2jpa.web;


import org.example.atelier2jpa.enteties.Product;
import org.example.atelier2jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestSercice { //web service si on envoie une request http/prodicte on envoie une liste de products en format json car on a utiliser un rest
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")//pour acceder a cet methode
    public List<Product> products(){

        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")//pour acceder a cet methode
    public Product findProduct(@PathVariable Long id){
        Product product = productRepository.findById(id).get();
        return product;
        //return productRepository.findById(id).orEse(null);
    }
}
