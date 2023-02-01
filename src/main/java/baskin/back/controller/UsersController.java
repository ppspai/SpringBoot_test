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
    // cors 설정 뚫음, 보안엔 안좋음, To DO
    @CrossOrigin("*")
    public String signUp(@RequestBody Users users){
        System.out.println(users.getName());
        System.out.println(users.getUser_id());
        System.out.println(users.getUser_pw());
        System.out.println(users.getBirth());
        System.out.println(users.getEmail());
        System.out.println(users.getPhone_number());
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
    public Users login(@RequestBody Users users){
        return usersService.login(users.getUser_id(), users.getUser_pw());
    }

}
