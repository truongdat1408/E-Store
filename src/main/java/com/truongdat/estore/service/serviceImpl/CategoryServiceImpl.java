package com.truongdat.estore.service.serviceImpl;

import com.truongdat.estore.dto.CategoryDTO;
import com.truongdat.estore.models.Category;
import com.truongdat.estore.repositories.CategoryRepository;
import com.truongdat.estore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return MapperEntityAndDTO.mapList(categories, CategoryDTO.class);
    }

    @Transactional
    @Override
    public void addCategory(String name, Integer sorting) {
        final String slug = name.toLowerCase().replaceAll(" ", "-");
        categoryRepository.save(new Category(name, slug, sorting));
    }

    @Transactional
    @Override
    public int getIdBySlug(String slug) {
        Category category = categoryRepository.findCategoryBySlug(slug);
        if(category != null){
            return category.getId();
        }
        return -1;
    }
}
