package baskin.back.controller;


import baskin.back.domain.Product;
import baskin.back.DTO.ProductDTO;
import baskin.back.service.ProductService;
import org.springframework.web.bind.annotation.*;

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
    public Optional<Product> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product;
    }

    @GetMapping("")
    public List<ProductDTO> findAll() {
        List<ProductDTO> abc = productService.findAll();
        return abc;
    }

    @GetMapping("search")
    public List<ProductDTO> findById(@RequestParam("name")String name){
        return productService.findByName(name);
    }

}
