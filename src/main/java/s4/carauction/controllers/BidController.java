package s4.carauction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s4.carauction.entities.Bid;
import s4.carauction.models.BidPlaceModel;
import s4.carauction.models.UserModel;
import s4.carauction.services.BidService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/bid")

public class BidController {

    private BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/")
    public ResponseEntity<?> placeBid(@RequestBody BidPlaceModel bidPlaceModel){
        return bidService.placeBid(bidPlaceModel);
    }

    @GetMapping("/")
    public Iterable<Bid> all(){
        return bidService.all();
    }
}
