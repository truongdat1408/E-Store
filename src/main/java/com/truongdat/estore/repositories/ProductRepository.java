package com.truongdat.estore.repositories;

import com.truongdat.estore.models.Category;
import com.truongdat.estore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
}
