package s4.carauction.models;

import lombok.Data;

@Data
public class AuctionCreateModel {
    private Long auctionId;
    private String seller;
    private String description;
    private String startDate;
    private String endDate;
    private String image;
    private CarCreateModel car;
    private Long userId;
}
