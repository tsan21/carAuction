package s4.carauction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s4.carauction.entities.Auction;
import s4.carauction.entities.Car;
import s4.carauction.entities.User;
import s4.carauction.models.AuctionCreateModel;
import s4.carauction.repos.AuctionRepo;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/auction")

public class AuctionController {
    @Autowired
    private AuctionRepo auctionRepo;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody AuctionCreateModel acm){
        if (acm != null){
            Car car = acm.getCar();
            User user = acm.getUser();

            Auction auction = new Auction(acm.getSeller(), acm.getDescription(), acm.getEndDate(), acm.getImage(), car, user);
            auctionRepo.save(auction);
            return new ResponseEntity<Error>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
    }
}
