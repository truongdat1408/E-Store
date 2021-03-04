package com.truongdat.estore.controllers.store;

import com.truongdat.estore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomepageController extends BaseController{
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String getHomepage(HttpSession session){
        session.setAttribute("productsList", null);
        return "estore/homepage";
    }

}
