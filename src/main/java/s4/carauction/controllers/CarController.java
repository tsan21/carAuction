package s4.carauction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s4.carauction.entities.Car;
import s4.carauction.models.CarCreateModel;
import s4.carauction.repos.CarRepo;
import s4.carauction.services.CarService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/car")

public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CarCreateModel ccm){
//        Car car = (Car) carService.create().getBody();
        return new ResponseEntity<>(carService.create(ccm), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public Iterable<Car> all(){
        return carService.all();
    }
}