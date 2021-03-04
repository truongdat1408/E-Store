package com.truongdat.estore.service.serviceImpl;

import com.truongdat.estore.dto.ProductDTO;
import com.truongdat.estore.models.Category;
import com.truongdat.estore.models.Product;
import com.truongdat.estore.repositories.CategoryRepository;
import com.truongdat.estore.repositories.ProductRepository;
import com.truongdat.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return MapperEntityAndDTO.mapList(products, ProductDTO.class);
    }

    @Transactional
    @Override
    public void addProduct(ProductDTO productDTO) {
        productRepository.save(MapperEntityAndDTO.map(productDTO, Product.class));
    }

    @Transactional
    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.getOne(id);
        return MapperEntityAndDTO.map(product, ProductDTO.class);
    }

    @Transactional
    @Override
    public void editProduct(ProductDTO productDTO) {
        Product product = productRepository.getOne(productDTO.getId());
        product.setId(productDTO.getId());
        product.setDescription(productDTO.getDescription());
        if(productDTO.getImage() != null) product.setImage(productDTO.getImage());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategoryId(Math.toIntExact(productDTO.getCategoryId()));
        productRepository.save(product);
    }

    @Transactional
    @Override
    public List<ProductDTO> getProductsByIdCategory(int idCategory) {
        Category category = categoryRepository.getOne(idCategory);
        List<Product> products = productRepository.findAllByCategory(category);
        return MapperEntityAndDTO.mapList(products, ProductDTO.class);
    }
}
