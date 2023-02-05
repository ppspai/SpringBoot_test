package baskin.back.controller;


import baskin.back.DTO.ProductFilterDTO;
import baskin.back.Mapper.ProductFilterMapper;
import baskin.back.domain.Product;
import baskin.back.DTO.ProductDTO;
import baskin.back.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product.getName(), product.getEnName(), product.getCategory_Id(), product.getDescription(), product.getKcal(), product.getSalt(), product.getSugar(), product.getFat(), product.getProtein(), product.getCaffeine(), product.getImg_Url());
        return "CREATE_DONE";
    }
    
    @GetMapping("{id}")
    public List<ProductDTO> findById(@PathVariable Long id) {
        List<ProductDTO> product = productService.findById(id);
        return product;
    }

    @GetMapping("all")
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> productlist = productService.findAll();

        return new ResponseEntity<>(productlist, HttpStatus.OK);
    }

    @GetMapping("")
    public List<ProductDTO> findById(@RequestParam("name")String name){
        return productService.findByName(name);
    }

    @CrossOrigin("*")
    @PostMapping("filter")
    public List<ProductFilterDTO> test(@RequestBody HashMap<String, Object> param){
        return productService.findProductByFilter(param);
    }


}
