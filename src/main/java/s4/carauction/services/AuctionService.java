package s4.carauction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s4.carauction.entities.Auction;
import s4.carauction.entities.Car;
import s4.carauction.entities.User;
import s4.carauction.models.AuctionCreateModel;
import s4.carauction.models.AuctionEditModel;
import s4.carauction.repos.AuctionRepo;


@Service
public class AuctionService {

    private AuctionRepo auctionRepo;

    @Autowired
    public AuctionService(AuctionRepo auctionRepo) {
        this.auctionRepo = auctionRepo;
    }

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

    public ResponseEntity<?> delete(Long auctionId){
        auctionRepo.deleteByAuctionId(auctionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> edit(AuctionEditModel aem){
        Auction auction = auctionRepo.findByAuctionId(aem.getAuctionId());
        auction.setSeller(aem.getSeller());
        auction.setDescription(aem.getDescription());
        auction.setEndDate(aem.getEndDate());
        auction.setImage(aem.getImage());
        auction.getCar().setBrand(aem.getCar().getBrand());
        auction.getCar().setModel(aem.getCar().getModel());
        auction.getCar().setBodyStyle(aem.getCar().getBodyStyle());
        auction.getCar().setColor(aem.getCar().getColor());
        auction.getCar().setEngine(aem.getCar().getEngine());
        auction.getCar().setMileage(aem.getCar().getMileage());
        auction.getCar().setProductionYear(aem.getCar().getProductionYear());

        auctionRepo.save(auction);
        return new ResponseEntity<>(auction, HttpStatus.OK);
    }
}
