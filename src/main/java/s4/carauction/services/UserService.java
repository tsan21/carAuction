package s4.carauction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s4.carauction.entities.User;
import s4.carauction.models.UserModel;
import s4.carauction.repos.UserRepo;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> register(UserModel userModel){
        if (!userExists(userRepo.findAll(), userModel.getName()) || !userModel.getName().equals("") || !userModel.getPassword().equals("")) {
            User user = new User(userModel.getName(), userModel.getPassword());
            userRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
    }

    public Iterable<User> all(){
        return userRepo.findAll();
    }

    public ResponseEntity<?> login(UserModel userModel){
        for (User u : userRepo.findAll()) {
            if (u.getName().equals(userModel.getName()) && u.getPassword().equals(userModel.getPassword())){
                return new ResponseEntity<>(u, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
    }

    public User findByUserId(Long userId){
        return userRepo.findByUserId(userId);
    }

    public boolean userExists(List<User> users, String userName){
        for (User user : users){
            if (user.getName().equals(userName)){
                return true;
            }
        }
        return false;
    }
}
