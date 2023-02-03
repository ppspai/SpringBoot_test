package baskin.back.service;


import baskin.back.DTO.ProductFilterDTO;
import baskin.back.Mapper.ProductFilterMapper;
import baskin.back.Mapper.ProductMapper;
import baskin.back.domain.Product;
import baskin.back.DTO.ProductDTO;
import baskin.back.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductFilterMapper productFilterMapper;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void createProduct(String ko_name, String en_name, Long category_id, String description, int kcal, int salt, int sugar, int fat, int protein, int caffeine, String img_url) {
        productRepository.createProduct(ko_name, en_name, category_id, description, kcal, salt, sugar, fat, protein, caffeine, img_url);
    }

    public List<ProductDTO> findById(Long id){
        List<ProductDTO> product = productMapper.findById(id);
        return product;
    }

    public List<ProductDTO> findAll() {
        List<ProductDTO> productList = productMapper.findAll();
        return productList;
    }

    // 검색기능
    public List<ProductDTO> findByName(String name) {
        return productMapper.findByName(name);
    }

    public List<ProductFilterDTO> findProductByFilter(HashMap param) {
        List<ProductFilterDTO> productList = productFilterMapper.findProductByFilter(param);
        if (param.get("allergy") != null) {
            String[] a = param.get("allergy").toString().split(",");
            List<ProductFilterDTO> clone = new ArrayList<>();
            for (ProductFilterDTO o : productList) {
                for (String p : a) {
                    if (o.getAllergy_name().contains(p)) {
                        clone.add(o);
                        break;
                    }
                }
            }
            return clone;
        } else {
            return productList;
        }
    }


    
}
