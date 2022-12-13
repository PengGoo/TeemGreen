package kiy3035.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "intro";

    }

    @RequestMapping("/intro")
    public String intro(){
        return "intro";
    }
    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
