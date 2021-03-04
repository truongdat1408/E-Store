package com.truongdat.estore.controllers.store;

import com.truongdat.estore.dto.CartDTO;
import com.truongdat.estore.dto.CartItem;
import com.truongdat.estore.dto.ProductDTO;
import com.truongdat.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class CartController extends BaseController{
    @Autowired
    private ProductService productService;

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("productId") Long productId,
                            HttpSession session){
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        if(cart == null){
            cart = new CartDTO();
        }
        //Add mot product vao cart
        ProductDTO product = productService.getProductById(productId);
        CartItem cartItem = new CartItem(product, (byte) 1, product.getPrice());
        cart.addCartItem(cartItem);

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/deleteCartItem/{productId}")
    public String deleteCartItem(@PathVariable("productId") Long productId,
                                 @SessionAttribute("cart") CartDTO cart){
        cart.removeCartItem(productId);
        return "redirect:/cart";
    }

    @GetMapping("increseQuantity/{productId}")
    public String increaseQuantity(@PathVariable("productId") Long productId,
                                   @SessionAttribute("cart") CartDTO cart){
        if(cart == null){
            return "redirect:/cart";
        }
        cart.increaseQuantityOfCartItem(productId);
        return "redirect:/cart";
    }

    @GetMapping("decreseQuantity/{productId}")
    public String decreaseQuantity(@PathVariable("productId") Long productId,
                                   @SessionAttribute("cart") CartDTO cart){
        if(cart == null){
            return "redirect:/cart";
        }
        cart.decreaseQuantityOfCartItem(productId);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getCart(){
        return "estore/cart";
    }
}
