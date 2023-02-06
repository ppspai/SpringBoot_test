package baskin.back.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String userid;
    @NotBlank
    private String userpw;

    private Long birth;
    @NotBlank
    private String email;
    @NotBlank
    private String phonenumber;

}
