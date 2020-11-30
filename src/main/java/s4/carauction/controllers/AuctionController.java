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
import s4.carauction.services.AuctionService;
import s4.carauction.services.CarService;
import s4.carauction.services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/auction")

public class AuctionController {
    @Autowired
    private AuctionService auctionService;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody AuctionCreateModel acm){
        System.out.println(acm.getEndDate());
        User u = userService.findByUserId(acm.getUserId());
        Car c = carService.create(acm.getCar());
        return auctionService.create(acm, u, c);
    }

    @GetMapping("/")
    public Iterable<Auction> all(){
        return auctionService.all();
    }

    @GetMapping("/{userId}")
    public Iterable<Auction> myAuctions(@PathVariable("userId") Long userId){
        return auctionService.getMyAuctions(userId);
    }
}
