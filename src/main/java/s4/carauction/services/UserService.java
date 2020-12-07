package s4.carauction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s4.carauction.entities.User;
import s4.carauction.models.UserModel;
import s4.carauction.repos.UserRepo;


@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public ResponseEntity<?> register(UserModel userModel){
        for (User u : userRepo.findAll()) {
            if (u.getName().equals(userModel.getName()) || userModel.getName().equals("") || userModel.getPassword().equals("")){
                return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
            }
        }
        User user = new User(userModel.getName(), userModel.getPassword());
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public Iterable<User> all(){
        return userRepo.findAll();
    }

    public ResponseEntity<?> login(UserModel userModel){
        User u = userRepo.findByNameAndPassword(userModel.getName(), userModel.getPassword());
        if (u==null){
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    public User findByUserId(Long userId){
        return userRepo.findByUserId(userId);
    }
}
