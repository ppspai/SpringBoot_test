package baskin.back.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Long id;
    private String name;
    private String en_name;
    private String category_name;
    private String description;
    private int kcal;
    private int salt;
    private int sugar;
    private int fat;
    private int protein;
    private int caffeine;
    private String img_url;
    private String tag_name;
    private String allergy_name;

}
