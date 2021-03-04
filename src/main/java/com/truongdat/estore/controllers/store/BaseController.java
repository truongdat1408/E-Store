package com.truongdat.estore.controllers.store;

import com.truongdat.estore.dto.CategoryDTO;
import com.truongdat.estore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class BaseController {
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<CategoryDTO> getCategories() {
        return categoryService.getAll();
    }
}
