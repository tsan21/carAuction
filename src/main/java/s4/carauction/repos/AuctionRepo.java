package s4.carauction.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s4.carauction.entities.Auction;

@Repository
public interface AuctionRepo extends JpaRepository<Auction, Long> {
    Iterable<Auction> findByUser_userId(Long userId);
}
