package s4.carauction.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s4.carauction.entities.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
