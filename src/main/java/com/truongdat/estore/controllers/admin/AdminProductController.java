package com.truongdat.estore.controllers.admin;

import com.truongdat.estore.dto.CategoryDTO;
import com.truongdat.estore.dto.ProductDTO;
import com.truongdat.estore.forms.ProductForm;
import com.truongdat.estore.models.Product;
import com.truongdat.estore.service.CategoryService;
import com.truongdat.estore.service.ProductService;
import com.truongdat.estore.service.serviceImpl.MapperEntityAndDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/admin/list-product")
    public String getListProduct(final Model model) {
        model.addAttribute("products", productService.getAll());
        List<ProductDTO> list = productService.getAll();
        return "admin/listProduct";
    }

    @GetMapping("/admin/add-product")
    public String getAddProduct(final Model model) {
        model.addAttribute("addProductForm", new ProductForm());
        return "admin/addProduct";
    }

    @PostMapping("/admin/add-product")
    public String postAddProduct(@Valid @ModelAttribute ProductForm productForm, BindingResult bindingResult,
                                 @RequestParam("productImage") MultipartFile productImage, Model model) throws IOException {
        if (bindingResult.hasErrors())  {
            return "admin/addProduct";
        }
        String filename = productImage.getOriginalFilename();
        productForm.setImage(filename);
        if (!filename.contains(".jpg") && !filename.contains(".png")) {
            model.addAttribute("message", "Invalid image file");
            return "admin/addProduct";
        }

        Path imagePath = Paths.get("src/main/resources/static/images/" + filename);
        Files.write(imagePath, productImage.getBytes());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productForm.getId());
        productDTO.setName(productForm.getName());
        productDTO.setDescription(productForm.getDescription());
        productDTO.setImage(productForm.getImage());
        productDTO.setQuantity(productForm.getQuantity());
        productDTO.setPrice(productForm.getPrice());
        productDTO.setCategoryId(productForm.getCategoryId());
        productService.addProduct(productDTO);
        //name, desc. quantity, price, category, image
        return "redirect:/admin/list-product";
    }

    @GetMapping("admin/edit-product/{productId}")
    public String getEditProduct(@PathVariable("productId") Long productId, final Model model) {
        ProductDTO product = productService.getProductById(productId);
        if (product == null) {
            return "redirect:/admin/list-product";
        }
        model.addAttribute("editProductForm", new ProductForm(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice(),
                product.getCategoryId(),
                product.getImage()
        ));
        model.addAttribute("titleEdit", product.getName());
        return "admin/editProduct";
    }

    @PostMapping("/admin/edit-product")
    public String postEditProduct(@Valid @ModelAttribute("editProductForm") ProductForm productForm, BindingResult bindingResult,
                                  @RequestParam("productImage") MultipartFile productImage, Model model) throws IOException {
        if (bindingResult.hasErrors())  {
            return "admin/editProduct";
        }

        String filename = null;
        if (productImage != null && !productImage.isEmpty()) {
            filename = productImage.getOriginalFilename();
            if (!filename.contains(".jpg") && !filename.contains(".png")) {
                model.addAttribute("message", "Invalid image file");
                return "admin/editProduct";
            }

            ProductDTO product = productService.getProductById(productForm.getId());

            Path  oldImagePath = Paths.get("src/main/resources/static/images/" + product.getImage());
            Files.delete(oldImagePath);
            Path newImagePath = Paths.get("src/main/resources/static/images/" + filename);
            Files.write(newImagePath, productImage.getBytes());
            productForm.setImage(filename);
        }

        productService.editProduct(MapperEntityAndDTO.map(productForm, ProductDTO.class));
        return "redirect:/admin/list-product";
    }

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<CategoryDTO> getCategories() {
        return categoryService.getAll();
    }
}
