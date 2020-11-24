package s4.carauction.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Auction {
    @Id
    @GeneratedValue
    private Long auctionId;
    private String seller;
    private String description;
    private Date startDate;
    private Date endDate;
    @OneToMany(mappedBy = "auction")
    private List<Image> images;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_Id")
    private Car car;
    @ManyToMany(mappedBy = "bidAuctions")
    private List<User> bidders;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;



    public Auction() {
    }

    public Auction(String seller, String description, Date startDate, Date endDate, List<Image> images, Car car, List<User> bidders, User user) {
        this.seller = seller;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.images = images;
        this.car = car;
        this.bidders = bidders;
        this.user = user;
    }

    public Auction(String seller, String description, Date startDate, Date endDate, List<Image> images, Car car, User user) {
        this.seller = seller;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.images = images;
        this.car = car;
        this.user = user;
    }

    public Auction(String seller, String description, Date startDate, Date endDate, List<Image> images) {
        this.seller = seller;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.images = images;
    }
}