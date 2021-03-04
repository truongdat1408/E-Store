package com.truongdat.estore.models;

import lombok.*;

import javax.management.ConstructorParameters;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String slug;

    private Integer sorting;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> products;

    public Category(@NotNull String name, @NotNull String slug, Integer sorting) {
        this.name = name;
        this.slug = slug;
        this.sorting = sorting;
    }
}
