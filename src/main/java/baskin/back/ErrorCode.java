package baskin.back;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DoNotExistIdException(404, "아이디가 존재하지 않습니다."),
    DoNotMatchPasswordException(404, "패스워드가 일치하지않습니다"),
    InvalidParameter(404, "찾으려는 정보가 없습니다"),
    DuplicateIdException(409, "중복된 아이디입니다.");




    private final int status;
    private final String message;
}
