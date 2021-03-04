package com.truongdat.estore.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Float price;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public void setCategoryId(Integer id) {
        this.category.setId(id);
    }
}
