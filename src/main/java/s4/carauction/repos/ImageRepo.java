package s4.carauction.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s4.carauction.entities.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
