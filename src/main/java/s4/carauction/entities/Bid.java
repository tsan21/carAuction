package s4.carauction.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Bid {
    @Id
    @GeneratedValue
    private Long bidId;
    private String bidder;
    private int amount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auction_Id")
    @JsonBackReference
    private Auction auction;

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

    public Bid(String bidder, int amount, Auction auction) {
        this.bidder = bidder;
        this.amount = amount;
        this.auction = auction;
    }
}
