package s4.carauction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s4.carauction.entities.Auction;
import s4.carauction.entities.Car;
import s4.carauction.entities.User;
import s4.carauction.models.AuctionCreateModel;
import s4.carauction.services.AuctionService;
import s4.carauction.services.CarService;
import s4.carauction.services.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/auction")

public class AuctionController {

    private AuctionService auctionService;
    private UserService userService;
    private CarService carService;

    @Autowired
    public AuctionController(AuctionService auctionService, UserService userService, CarService carService) {
        this.auctionService = auctionService;
        this.userService = userService;
        this.carService = carService;
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody AuctionCreateModel acm){
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
