package s4.carauction.models;

import lombok.Data;
import s4.carauction.entities.Car;
import s4.carauction.entities.User;
import java.util.Date;
import java.util.List;

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
