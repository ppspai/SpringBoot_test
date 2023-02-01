package baskin.back.service;


import baskin.back.Mapper.ProductMapper;
import baskin.back.domain.Product;
import baskin.back.domain.ProductDTO;
import baskin.back.repository.ProductRepository;
import baskin.back.repository.ProductRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductRepositorySupport productRepositorySupport;
    @Autowired
    ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductRepositorySupport productRepositorySupport){
        this.productRepository = productRepository;
        this.productRepositorySupport = productRepositorySupport;
    }

    public void createProduct(String ko_name, String en_name, Long category_id, String description, int kcal, int salt, int sugar, int fat, int protein, int caffeine, String img_url) {
        productRepository.createProduct(ko_name, en_name, category_id, description, kcal, salt, sugar, fat, protein, caffeine, img_url);
    }

    public Optional<Product> findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public List<ProductDTO> findAll() {
        List<ProductDTO> productList = productMapper.findAll();
        return productList;
    }

    public List<Product> findbyName(String name) {
        return productRepository.findBynameContaining(name);
    }

    
}
