package s4.carauction.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s4.carauction.entities.Auction;


@Repository
@Transactional
public interface AuctionRepo extends JpaRepository<Auction, Long> {
    Iterable<Auction> findByUser_userId(Long userId);
    Auction findByAuctionId(Long auctionId);
    void deleteByAuctionId(Long auctionId);
}
