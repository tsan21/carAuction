package s4.carauction.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue
    private Long carId;
    private String brand;
    private String model;
    private String bodyStyle;
    private String color;
    private String engine;
    private int mileage;
    private int productionYear;
//    @OneToOne(mappedBy = "car")
//    private Auction auction;



    public Car() {
    }

    public Car(String brand, String model, String bodyStyle, String color, String engine, int mileage, int productionYear) {
        this.brand = brand;
        this.model = model;
        this.bodyStyle = bodyStyle;
        this.color = color;
        this.engine = engine;
        this.mileage = mileage;
        this.productionYear = productionYear;
    }
}
