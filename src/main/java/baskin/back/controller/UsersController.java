package baskin.back.controller;


import baskin.back.CustomException;
import baskin.back.DTO.ErrorDTO;
import baskin.back.domain.Users;
import baskin.back.service.UsersService;
import org.postgresql.util.PSQLException;
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
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody Users users) throws Exception{
        usersService.signUp(users);
        Map<String, Object> result = new HashMap<>();
        result.put("statusCode", "201");
        result.put("message", "회원가입 완료");
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("findAll")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> findAll() {
        List<Users> allUsers = usersService.findAll();
        Map<String, Object> result = new HashMap<>();
        result.put("statusCode", "200");
        result.put("data", allUsers);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("")
    public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody Users users) throws PSQLException {
        usersService.deleteUser(users);
        Map<String, Object> result = new HashMap<>();
        result.put("statusCode", "200");
        result.put("message", "회원 탈퇴 완료");

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
    public ResponseEntity<Map<String, Object>> login(@RequestBody Users users){
        Users user =usersService.login(users.getUserid(), users.getUserpw());
        Map<String, Object> result = new HashMap<>();
        result.put("statusCode", "200");
        result.put("data", user);
        return ResponseEntity.ok().body(result);
    }

}
