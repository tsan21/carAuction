package s4.carauction.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s4.carauction.entities.User;
import s4.carauction.models.UserModel;
import s4.carauction.repos.UserRepo;
import s4.carauction.services.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/register")

public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    private UserService userService = new UserService();

    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody UserModel userModel){
        if (userService.validateRegister(userRepo.findAll(), userModel.getName(), userModel.getPassword())){
            User user = new User(userModel.getName(), userModel.getPassword());
            userRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    public Iterable<User> all(){
        return userRepo.findAll();
    }
}