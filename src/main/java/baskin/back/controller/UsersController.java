package baskin.back.controller;


import baskin.back.CustomException;
import baskin.back.DTO.ErrorDTO;
import baskin.back.domain.Users;
import baskin.back.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsersController {
    
    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }


    @PostMapping("signUp")
    public ResponseEntity<Map<String, Object>> test(@RequestBody Users users) throws Exception{
        usersService.signUp(users);
        Map<String, Object> result = new HashMap<>();
        result.put("message", "회원가입 완료");
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("findAll")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> findAll() {
        List<Users> allUsers = usersService.findAll();
        Map<String, Object> result = new HashMap<>();
        result.put("data", allUsers);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("existUser")
    public boolean existUser(@RequestBody Users users) {
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
