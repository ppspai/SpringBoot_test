package baskin.back.service;


import baskin.back.domain.Users;
import baskin.back.repository.UsersRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public void signUp(String name, String user_id, String user_pw, Long birth, String email, String phone_number){
        try {
            // 비밀번호 암호화 해서 DB에 저장
            user_pw = hashedPassword(user_pw);

            if (usersRepository.existUser(user_id) != null) {
                throw new Error("중복되는 아이디입니다.");
            } else {
                usersRepository.signUp(name, user_id, user_pw, birth, email, phone_number);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Users login(String user_id, String user_pw){
        try{
            Users users = usersRepository.existUser(user_id);
            if(users == null) {
                throw new Error("일치하는 아이디가 없습니다.");
                // 입력한 비밀번호와 암호화된 비밀번호 해독 후 비교
            } else if (!checkPass(user_pw, users.getUser_pw())){
                throw new Error("비밀번호가 틀렸습니다.");
            } else {
                return users;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }  
        return null;
        
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
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
