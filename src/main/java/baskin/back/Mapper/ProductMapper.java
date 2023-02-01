package baskin.back.Mapper;


import baskin.back.domain.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface ProductMapper {
    List<ProductDTO> getProduct();
    List<ProductDTO> findAll();
}
