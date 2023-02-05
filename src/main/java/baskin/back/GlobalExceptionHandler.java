package baskin.back;

import baskin.back.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({CustomException.class})
    protected ResponseEntity handleCustomException(CustomException e){
        return new ResponseEntity(new ErrorDTO(e.getErrorCode().getStatus(), e.getErrorCode().getMessage()), HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }


}
