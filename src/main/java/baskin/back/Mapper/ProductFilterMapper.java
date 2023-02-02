package baskin.back.Mapper;

import baskin.back.DTO.ProductFilterDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
@Component
public interface ProductFilterMapper {
    List<ProductFilterDTO> findProductByFilter(HashMap param);
}
