package com.truongdat.estore.controllers.store;

import com.truongdat.estore.dto.ProductDTO;
import com.truongdat.estore.service.CategoryService;
import com.truongdat.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CategoryController extends BaseController {
    private final int PAGE_SIZE = 3;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/categories/{slugCategory}")
    public String getListProducts(@PathVariable("slugCategory") String slugCategory,
                                  Model model,
                                  HttpSession session,
                                  @RequestParam(value = "page", required = true, defaultValue = "1")
                                          Integer currentPage) {

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("category_slug", slugCategory);

        int idCategory = categoryService.getIdBySlug(slugCategory);
        List<ProductDTO> list = productService.getProductsByIdCategory(idCategory);
        PagedListHolder<?> pages = new PagedListHolder<>(list);
        pages.setPageSize(PAGE_SIZE);
        final int goToPage = currentPage - 1;

        if (goToPage <= pages.getPageCount() && goToPage >= 0) {
            pages.setPage(goToPage);
        }

        session.setAttribute("productsList", pages);

        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("products", pages);

        return "estore/listCategoryBySlug";
    }
}
