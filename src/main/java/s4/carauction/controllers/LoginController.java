package s4.carauction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s4.carauction.entities.User;
import s4.carauction.models.UserModel;
import s4.carauction.services.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/login")

public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody UserModel userModel){
        return userService.login(userModel);
    }

    @GetMapping("/{userId}")
    public User findByUserId(@PathVariable("userId") Long userId){
        return userService.findByUserId(userId);
    }

}
