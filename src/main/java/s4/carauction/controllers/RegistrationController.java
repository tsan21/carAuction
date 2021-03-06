package s4.carauction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s4.carauction.entities.User;
import s4.carauction.models.UserModel;
import s4.carauction.services.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/register")

public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody UserModel userModel){
       return userService.register(userModel);
    }

    @GetMapping("/")
    public Iterable<User> all(){
        return userService.all();
    }
}