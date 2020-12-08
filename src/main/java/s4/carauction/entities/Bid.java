package s4.carauction.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Bid {
    @Id
    @GeneratedValue
    private Long bidId;
    private String bidder;
    private int amount;

    public Bid() {
    }

    public Bid(String bidder, int amount) {
        this.bidder = bidder;
        this.amount = amount;
    }

    public Bid(Long bidId, String bidder, int amount) {
        this.bidId = bidId;
        this.bidder = bidder;
        this.amount = amount;
    }
}
