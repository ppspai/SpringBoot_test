package baskin.back.Mapper;


import baskin.back.DTO.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface ProductMapper {
    List<ProductDTO> findAll();
    List<ProductDTO> findByName(String name);

    ProductDTO findById(Long id);
}
