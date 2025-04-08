package org.example.atelier2jpa.repository;

import org.example.atelier2jpa.enteties.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//pour gere mais produit j'ai besoin de spring data pour cela on a cree cette interface
//pour utiliser spring dat aon doit héité de JpaRepository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByNameContains(String mc);
  List<Product> findByPriceGreaterThan(double price);

  @Query("select p from Product p where p.name like :x")
  List<Product> search(@Param("x") String mc);

  @Query("select p from Product p where p.price  > :x")
  List<Product> searchByPrice(@Param("x") double price);


}

