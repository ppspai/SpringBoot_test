package baskin.back.controller;


import baskin.back.domain.Users;
import baskin.back.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    
    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping("signUp")
    @ResponseBody
    // cors 설정 뚫음, 보안엔 안좋음, TODO
    @CrossOrigin("*")
    public String signUp(@RequestBody Users users){
        usersService.signUp(users.getName(), users.getUser_id(), users.getUser_pw(), users.getBirth(), users.getEmail(), users.getPhone_number());
        return "회원가입이 완료 되었습니다.";
    }

    @GetMapping("findAll")
    @ResponseBody
    public List<Users> findAll() {
        List<Users> allUsers = usersService.findAll();
        return allUsers;
    }

    @PostMapping("login")
    @ResponseBody
    @CrossOrigin("*")
    public Users login(@RequestBody Users users){
        Users user =usersService.login(users.getUser_id(), users.getUser_pw());
        return user;
    }

}
