package org.example.atelier2jpa.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //on utilise lombouk la notation data lombouk ajoute automatiquement les getters et setters
@NoArgsConstructor @AllArgsConstructor  //@Builder
@Entity

public class Product {//si je ne fais oas @id product sera souligne en rouge car il doit avoir un identifiant
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private  int quantity;


}
