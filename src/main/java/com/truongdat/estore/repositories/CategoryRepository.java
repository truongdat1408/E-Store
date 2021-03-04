package com.truongdat.estore.repositories;

import com.truongdat.estore.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryBySlug(String slug);
}
