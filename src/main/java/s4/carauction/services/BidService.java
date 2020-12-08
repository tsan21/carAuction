package s4.carauction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s4.carauction.repos.BidRepo;

@Service
public class BidService {

    private BidRepo bidRepo;

    @Autowired
    public BidService(BidRepo bidRepo) {
        this.bidRepo = bidRepo;
    }
}
