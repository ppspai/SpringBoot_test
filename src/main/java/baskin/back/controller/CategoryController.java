package baskin.back.controller;


import baskin.back.domain.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import baskin.back.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category.getCategory_Name());
        return "CREATE_DONE";
    }

    @GetMapping("")
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
