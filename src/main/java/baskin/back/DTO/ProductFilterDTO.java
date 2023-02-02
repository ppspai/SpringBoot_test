package baskin.back.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductFilterDTO {
    private Long id;
    private String name;
    private int kcal;
    private int salt;
    private int sugar;
    private int fat;
    private int protein;
    private int caffeine;

    private String allergy_name;

}
