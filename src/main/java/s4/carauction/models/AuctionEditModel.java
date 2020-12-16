package s4.carauction.models;

import lombok.Data;
import s4.carauction.entities.Car;

@Data
public class AuctionEditModel {
    private Long auctionId;
    private String Seller;
//    private String brand;
//    private String model;
//    private String bodyStyle;
//    private String color;
//    private String engine;
    private String description;
    private String image;
    private String endDate;
//    private int mileage;
//    private int productionYear;
    private Car car;
}
