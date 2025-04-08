package org.example.atelier2jpa;

import org.example.atelier2jpa.enteties.Product;
import org.example.atelier2jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Atelier2JpaApplication implements CommandLineRunner {
    @Autowired // injection des dépend
    private ProductRepository productRepository;
    //démarage de spring
    public static void main(String[] args) {
        SpringApplication.run(Atelier2JpaApplication.class, args);
    }

   //une fois spring démare fais appl a la methode run
    @Override
    public void run(String... args) throws Exception {
       //productRepository.save(new Product(null,"Computer",4300,3));
        //productRepository.save(new Product(null,"Printer",1204,4));
        //productRepository.save(new Product(null,"Smartphone",3200,5));
        //afficher list de produis
        List<Product> products = productRepository.findAll();
       //products.forEach(System.out::println);
        products.forEach(p ->{
            System.out.println(p.toString());
        } );
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*********");
        //System.out.println(product);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("*********");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p ->{System.out.println(p);});
        System.out.println("*********");

        List<Product> productList2 = productRepository.search("%C%");
        productList.forEach(p ->{System.out.println(p);});

        System.out.println("*********");
        List<Product> productList4 = productRepository.findByPriceGreaterThan(3000);
        productList.forEach(p ->{System.out.println(p);});


        System.out.println("*********");
        List<Product> productList3 = productRepository.searchByPrice(3000);
        productList.forEach(p ->{System.out.println(p);});
        //H2 déatabse c'est une database memory une fois j'arrete app je perdre les infos
    }


}
