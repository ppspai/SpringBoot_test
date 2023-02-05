package baskin.back.service;


import baskin.back.domain.Users;
import baskin.back.repository.UsersRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public void signUp(Users users){
        try {
            if(usersRepository.existUser(users.getUserid()) != null) {
                throw new Error("이미 존재하는 ID입니다.");
            }
            String user_pw = hashedPassword(users.getUserpw());
            users.setUserpw(user_pw);
            usersRepository.save(users);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public Users login(String userid, String userpw){
        try{
            Users users = usersRepository.existUser(userid);
            if(users == null) {
                throw new Error("일치하는 아이디가 없습니다.");
                // 입력한 비밀번호와 암호화된 비밀번호 해독 후 비교
            } else if (!checkPass(userpw, users.getUserpw())){
                throw new Error("비밀번호가 틀렸습니다.");
            } else {
                return users;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }  
        return null;
        
    }

    public Users existUser(String userid){
        Users user = usersRepository.existUser(userid);
        return user;
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
