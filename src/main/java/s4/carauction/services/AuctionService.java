package s4.carauction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s4.carauction.entities.Auction;
import s4.carauction.entities.Car;
import s4.carauction.entities.User;
import s4.carauction.models.AuctionCreateModel;
import s4.carauction.repos.AuctionRepo;

@Service
public class AuctionService {
    @Autowired
    private AuctionRepo auctionRepo;

    public ResponseEntity<?> create(AuctionCreateModel acm, User user, Car car){
        if (acm != null){
            Auction auction = new Auction(acm.getSeller(), acm.getDescription(), acm.getStartDate(), acm.getEndDate(), acm.getImage(), car, user);
            auctionRepo.save(auction);
            return new ResponseEntity<Error>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
    }

    public Iterable<Auction> all(){
        return auctionRepo.findAll();
    }

    public Iterable<Auction> getMyAuctions(Long userId){
        return auctionRepo.findByUser_userId(userId);
    }
}
