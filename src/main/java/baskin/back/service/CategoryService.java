package baskin.back.service;


import baskin.back.domain.Category;
import baskin.back.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(String category_name) {
        categoryRepository.createCategory(category_name);
    }

    public List<Category> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }
}
