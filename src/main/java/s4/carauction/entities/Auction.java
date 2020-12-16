package s4.carauction.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
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
    private String startDate;
    private String endDate;
    private String image;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_Id")
    private Car car;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "auction_Id")
    private List<Bid> bids;
    @JsonBackReference
    @ManyToOne
    private User user;



    public Auction() {
    }

    public Auction(String seller, String description, String startDate, String endDate, String image, Car car, List<Bid> bids) {
        this.seller = seller;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
        this.car = car;
        this.bids = bids;
    }

    public Auction(String seller, String description,String startDate, String endDate, String image, Car car, User user) {
        this.seller = seller;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
        this.car = car;
        this.user = user;
    }

    public Auction(String seller, String description, String startDate, String endDate, String image) {
        this.seller = seller;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
    }
}