package s4.carauction.models;

import lombok.Data;

@Data
public class BidPlaceModel {
    private String bidder;
    private int amount;
    private Long auctionId;
}
