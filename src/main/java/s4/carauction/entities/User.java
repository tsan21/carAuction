package s4.carauction.entities;

import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Auction> myAuctions;
    @ManyToMany
    @JoinTable(
            name = "bid",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "auctionId"))
    private List<Auction> bidAuctions;



    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, List<Auction> myAuctions, List<Auction> bidAuctions) {
        this.name = name;
        this.password = password;
        this.myAuctions = myAuctions;
        this.bidAuctions = bidAuctions;
    }
}