package baskin.back.domain;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String name;

    private String enName;
    private Long category_Id;
    private String description;
    private int kcal;
    private int salt;
    private int sugar;
    private int fat;
    private int protein;
    private int caffeine;
    private String img_Url;


//    @OneToOne
//    @JoinColumn(name = "id")
//    private Category category;
//
//    @ManyToMany
//    @JoinTable(name = "Allergy",
//                joinColumns = @JoinColumn(name = "id"),
//                inverseJoinColumns = @JoinColumn(name = "allergy_Id"))
//    private List<ProductAllergy> ProductAllergy;
//
//    @ManyToMany
//    @JoinTable(name = "Tag",
//                joinColumns = @JoinColumn(name = "id"),
//                inverseJoinColumns = @JoinColumn(name = "tag_Id"))
//    private List<Producttag> Producttag;

}
