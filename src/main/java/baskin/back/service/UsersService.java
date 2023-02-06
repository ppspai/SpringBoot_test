package baskin.back.service;


import baskin.back.CustomException;
import baskin.back.domain.Users;
import baskin.back.repository.UsersRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.mindrot.jbcrypt.BCrypt;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;
import java.util.List;

import static baskin.back.ErrorCode.*;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public void signUp(Users users){
        if(usersRepository.existUser(users.getUserid()) != null) {
            throw new CustomException(DuplicateIdException);
        }
        String user_pw = hashedPassword(users.getUserpw());
        users.setUserpw(user_pw);
        usersRepository.save(users);
    }

    public Users login(String userid, String userpw){
        Users users = usersRepository.existUser(userid);
        if(users == null) {
            throw new CustomException(DoNotExistIdException);
            // 입력한 비밀번호와 암호화된 비밀번호 해독 후 비교
        } else if (!checkPass(userpw, users.getUserpw())){
            throw new CustomException(DoNotMatchPasswordException);
        } else {
            return users;
        }
    }

    public Users existUser(String userid){
        Users user = usersRepository.existUser(userid);
        return user;
    }

    public List<Users> findAll() {
        List<Users> userList = usersRepository.findAll();
        if (userList.isEmpty()){
            throw new CustomException(InvalidParameter);
        }
        return userList;
    }

    public void deleteUser(Users users){
        Users user = usersRepository.existUser(users.getUserid());
        if(user == null){
            throw new CustomException(DoNotExistIdException);
        } else if(!checkPass(users.getUserpw(), user.getUserpw())){
            throw new CustomException(DoNotMatchPasswordException);
        } else {
            usersRepository.deleteUser(users.getUserid());
        }
    }



    // 비밀번호 암호화
    private String hashedPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // 비밀번호 해독
    private Boolean checkPass(String password, String hashedPassword) {
        return (BCrypt.checkpw(password, hashedPassword)) ? true : false;
    }
}
