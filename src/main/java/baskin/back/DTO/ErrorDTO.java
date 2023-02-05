package baskin.back.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDTO {
    private int status;
    private String message;
}
