package baskin.back.service;


import baskin.back.CustomException;
import baskin.back.DTO.ProductFilterDTO;
import baskin.back.Mapper.ProductFilterMapper;
import baskin.back.Mapper.ProductMapper;
import baskin.back.domain.Product;
import baskin.back.DTO.ProductDTO;
import baskin.back.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static baskin.back.ErrorCode.InvalidParameter;

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

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public ProductDTO findById(Long id){
        ProductDTO product = productMapper.findById(id);
        if(product == null){
            throw new CustomException(InvalidParameter);
        }
        return product;
    }

    public List<ProductDTO> findAll() {
        List<ProductDTO> productList = productMapper.findAll();
        return productList;
    }

    // 검색기능
    public List<ProductDTO> findByName(String name) {
        List<ProductDTO> productList = productMapper.findByName(name);
        if(productList.isEmpty()) {
            throw new CustomException(InvalidParameter);
        }
        return productList;
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
            if(clone.isEmpty()){
                throw new CustomException(InvalidParameter);
            }
            return clone;
        } else {
            if(productList.isEmpty()){
                throw new CustomException(InvalidParameter);
            }
            return productList;
        }
    }
}
