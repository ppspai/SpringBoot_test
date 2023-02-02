package baskin.back.repository;


import baskin.back.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Product (name, enName, category_id, description, kcal, salt, sugar, fat, protein, caffeine, img_url) VALUES (:ko_name, :en_name, :category_id, :description, :kcal, :salt, :sugar, :fat, :protein, :caffeine, :img_url)", nativeQuery = true)
    public void createProduct(@Param("ko_name")String ko_name, @Param("en_name")String en_name, @Param("category_id") Long cateogry_id, @Param("description")String description, @Param("kcal")Integer kcal, @Param("salt")Integer salt, @Param("sugar")Integer sugar, @Param("fat")Integer fat, @Param("protein")Integer protein, @Param("caffeine")Integer caffeine, @Param("img_url")String img_url);


    public Optional<Product> findById(Long id);

    public List<Product> findAll();



}
