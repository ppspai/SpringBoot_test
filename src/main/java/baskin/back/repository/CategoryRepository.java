package baskin.back.repository;


import baskin.back.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO category (category_name) VALUES (:category_name)", nativeQuery = true)
    public void createCategory(@Param("category_name")String category_name);

    public List<Category> findAll();

}
