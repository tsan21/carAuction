package s4.carauction.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Auction> myAuctions;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_Id")
    private List<Bid> myBids;



    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, List<Auction> myAuctions) {
        this.name = name;
        this.password = password;
        this.myAuctions = myAuctions;
    }

    public User(String name, String password, List<Auction> myAuctions, List<Bid> myBids) {
        this.name = name;
        this.password = password;
        this.myAuctions = myAuctions;
        this.myBids = myBids;
    }
}