package s4.carauction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s4.carauction.entities.Car;
import s4.carauction.models.CarCreateModel;
import s4.carauction.repos.CarRepo;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public Car create(CarCreateModel ccm){
        Car car = new Car(ccm.getBrand(), ccm.getModel(), ccm.getBodyStyle(), ccm.getColor(), ccm.getEngine(), ccm.getMileage(), ccm.getProductionYear());
        carRepo.save(car);
        return car;
    }

    public Iterable<Car> all(){
        return carRepo.findAll();
    }
}
