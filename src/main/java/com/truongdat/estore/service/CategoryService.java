package com.truongdat.estore.service;

import com.truongdat.estore.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();
    void addCategory(String name, Integer sorting);
    int getIdBySlug(String slug);
}
