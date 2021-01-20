package s4.carauction.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class TestController {

    @RequestMapping("/")
    public String test(){
        return "this is car auction test";
    }
}
