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
@RequestMapping(value="/login")

public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody UserModel userModel){
        for (User u : userRepo.findAll()) {
            if (u.getName().equals(userModel.getName()) && u.getPassword().equals(userModel.getPassword())){
                return new ResponseEntity<>(u, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
    }
}
