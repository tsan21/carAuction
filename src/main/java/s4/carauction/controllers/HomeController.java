package s4.carauction.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "this is my car auction";
    }
}
