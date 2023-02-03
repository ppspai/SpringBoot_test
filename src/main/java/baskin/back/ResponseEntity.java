package baskin.back;

import baskin.back.DTO.ProductDTO;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;


public class ResponseEntity<ProductDTO> extends HttpEntity<ProductDTO> {

    private final HttpStatus status;

    public ResponseEntity(@Nullable ProductDTO body, @Nullable MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers);
        Assert.notNull(status, "HttpStatus must not be null");
        this.status = status;
    }

}
