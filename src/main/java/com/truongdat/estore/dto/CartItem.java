package com.truongdat.estore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private ProductDTO product;
    private Byte quantity;
    private Float total;

    public CartItem(ProductDTO product, Byte quantity, Float total) {
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }
}
