package com.truongdat.estore.dto;

import java.util.ArrayList;

public class CartDTO {
    private ArrayList<CartItem> cartItems;

    public CartDTO(){
        cartItems = new ArrayList<>();
    }

    public ArrayList<CartItem> getCartItems(){
        return cartItems;
    }

    public void addCartItem(CartItem cartItem){
        for (CartItem i : cartItems){
            //Neu da them vao cart thi chi tang no len 1 so luong
            if(i.getProduct().getId().equals(cartItem.getProduct().getId())){
                i.setQuantity((byte) (i.getQuantity() + 1));
                i.setTotal(i.getQuantity() * i.getProduct().getPrice());
                return;
            }
        }
        cartItems.add(cartItem);
    }

    public void increaseQuantityOfCartItem(Long productId){
        for (CartItem i : cartItems){
            //Neu da them vao cart thi chi tang no len 1 so luong
            if(i.getProduct().getId().equals(productId)){
                if(i.getQuantity() < 10){
                    i.setQuantity((byte) (i.getQuantity() + 1));
                    i.setTotal(i.getQuantity() * i.getProduct().getPrice());
                }
                return;
            }
        }
    }

    public void decreaseQuantityOfCartItem(Long productId){
        for (CartItem i : cartItems){
            //Neu da them vao cart thi chi tang no len 1 so luong
            if(i.getProduct().getId().equals(productId)){
                if(i.getQuantity() > 1){
                    i.setQuantity((byte) (i.getQuantity() - 1));
                    i.setTotal(i.getQuantity() * i.getProduct().getPrice());
                }
                return;
            }
        }
    }

    public void removeCartItem(Long productId){
        for (CartItem i : cartItems){
            if(i.getProduct().getId().equals(productId)){
                cartItems.remove(i);
                return;
            }
        }
    }
}
