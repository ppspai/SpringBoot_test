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
    public String test(@RequestBody Users users){
        usersService.signUp(users);
        return "회원가입 완료";
    }

    @GetMapping("findAll")
    @ResponseBody
    public List<Users> findAll() {
        List<Users> allUsers = usersService.findAll();
        return allUsers;
    }

    @PostMapping("existUser")
    public boolean existUser(@RequestBody Users users) {
        System.out.println(users);
        if (usersService.existUser(users.getUserid()) != null) {
            return true;
        } else {
            return false;
        }
    }


    @PostMapping("login")
    @ResponseBody
    @CrossOrigin("*")
    public Users login(@RequestBody Users users){
        Users user =usersService.login(users.getUserid(), users.getUserpw());
        return user;
    }

}
