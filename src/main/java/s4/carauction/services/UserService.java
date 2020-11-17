package s4.carauction.services;

import s4.carauction.entities.User;
import java.util.List;

public class UserService {
    public boolean validateRegister(List<User> users, String userName, String password){
        if (userExists(users,userName) || userName.equals("") || password.equals("")) {
            return false;
        }
        return true;
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
