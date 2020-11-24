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
    private Date startDate;
    private Date endDate;
    private String image;
    private Car car;
    private List<User> bidders;
    private User user;
}
