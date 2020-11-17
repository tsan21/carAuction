package s4.carauction.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s4.carauction.entities.User;
import s4.carauction.models.UserModel;
import s4.carauction.repos.UserRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/user")

public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(path = "/")
    public ResponseEntity<?> login(@RequestBody UserModel userModel){
        for (User u : userRepo.findAll()) {
            if (u.getName().equals(userModel.getName()) && u.getPassword().equals(userModel.getPassword())){
                return new ResponseEntity<>(u.getUserId(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody UserModel userModel){
        if (!userExists(userModel.getName()) || userModel.getName().isEmpty()|| userModel.getPassword().isEmpty()){
            User user = new User(userModel.getName(), userModel.getPassword());
            userRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public Iterable<User> all(){
        return userRepo.findAll();
    }

    public boolean userExists(String userName){
        for (User user : userRepo.findAll()){
            if (user.getName().equals(userName)){
                return true;
            }
        }
        return false;
    }
}