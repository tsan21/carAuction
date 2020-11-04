package s4.carauction.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue
    private Long imageId;
    private String imageString;
    @ManyToOne
    @JoinColumn(name = "auctionId", nullable = false)
    private Auction auction;



    public Image() {
    }

    public Image(String imageString, Auction auction) {
        this.imageString = imageString;
        this.auction = auction;
    }

    public Image(String imageString) {
        this.imageString = imageString;
    }
}