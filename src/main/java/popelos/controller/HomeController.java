package popelos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @RequestMapping
    public String showHome(){
        return "home";
    }
}
