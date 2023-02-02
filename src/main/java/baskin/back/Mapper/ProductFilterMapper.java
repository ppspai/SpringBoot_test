package baskin.back.mapper;

import baskin.back.DTO.ProductFilterDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface ProductFilterMapper {
    List<ProductFilterDTO> findProductFilter();
}
