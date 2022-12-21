package kiy3035.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
    @RequestMapping("/review/helper")
    public String reHelper(){
        return "review/rehelper";
    }

    @RequestMapping("/review/parents")
    public String reParents(){
        return "review/reparents";
    }
}
