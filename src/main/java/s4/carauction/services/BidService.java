package s4.carauction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s4.carauction.entities.Auction;
import s4.carauction.entities.Bid;
import s4.carauction.models.BidPlaceModel;
import s4.carauction.repos.AuctionRepo;
import s4.carauction.repos.BidRepo;

@Service
public class BidService {

    private BidRepo bidRepo;
    private AuctionRepo auctionRepo;

    @Autowired
    public BidService(BidRepo bidRepo, AuctionRepo auctionRepo) {
        this.bidRepo = bidRepo;
        this.auctionRepo = auctionRepo;
    }

    public ResponseEntity<?> placeBid(BidPlaceModel bidPlaceModel){
        Auction auction = auctionRepo.findByAuctionId(bidPlaceModel.getAuctionId());
        Bid bid = new Bid(bidPlaceModel.getBidder(), bidPlaceModel.getAmount(), auction);
        auction.getBids().add(bid);

        auctionRepo.save(auction);
        bidRepo.save(bid);
        return new ResponseEntity<>(bid, HttpStatus.CREATED);
    }

    public Iterable<Bid> all(){
        return bidRepo.findAll();
    }
}
