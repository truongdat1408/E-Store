package com.truongdat.estore.controllers.admin;

import com.truongdat.estore.forms.AddCategoryForm;
import com.truongdat.estore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminCategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("admin")
    public String getAdmin(){return "redirect:/admin/categories";}

    @GetMapping("admin/categories")
    public String getListCategory(final Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "admin/categories";
    }

    @GetMapping("/admin/add-category")
    public String getAddCategory(final Model model) {
        model.addAttribute("addCategoryForm", new AddCategoryForm());
        return "admin/addCategory";
    }

    @PostMapping("/admin/add-category")
    public String postAddCategory(@Valid @ModelAttribute("addCategoryForm") AddCategoryForm categoryForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return "admin/addCategory";
        }
        final String name = categoryForm.getName();
        final Integer sorting = categoryForm.getSorting();

        categoryService.addCategory(name, sorting);
        return "redirect:/admin/categories";

    }
}
