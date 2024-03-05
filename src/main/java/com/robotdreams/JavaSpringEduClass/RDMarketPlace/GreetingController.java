package com.robotdreams.JavaSpringEduClass.RDMarketPlace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public void greeting(Model model) {
        Greeting greeting = new Greeting("Hoş geldiniz Spring Boot MVC dünyasına!");
        model.addAttribute("greeting", greeting);
    }

}
