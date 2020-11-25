package s4.carauction.models;

import lombok.Data;
import s4.carauction.entities.Auction;

import javax.persistence.OneToOne;

@Data
public class CarCreateModel {
    private Long carId;
    private String brand;
    private String model;
    private String bodyStyle;
    private String color;
    private String engine;
    private int mileage;
    private int productionYear;
}
