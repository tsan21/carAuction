package s4.carauction.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s4.carauction.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserId(Long userId);
    User findByNameAndPassword(String name, String password);
}
