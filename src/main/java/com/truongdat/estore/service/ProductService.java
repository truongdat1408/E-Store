package com.truongdat.estore.service;

import com.truongdat.estore.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    void addProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    void editProduct(ProductDTO productDTO);

    List<ProductDTO> getProductsByIdCategory(int idCategory);
}
