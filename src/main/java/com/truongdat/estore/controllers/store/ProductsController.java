package com.truongdat.estore.controllers.store;

import com.truongdat.estore.dto.ProductDTO;
import com.truongdat.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductsController extends BaseController{
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{productId}")
    public String getDetailOfProduct(@PathVariable("productId") Long productId,
                                     Model model){
        ProductDTO product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "estore/detailProduct";
    }
}
