package kiy3035.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommutingCotroller {


    @RequestMapping("/commuting/bootak")
    public String helperList(){
        return "thymeleaf/commuting/commuting_bootak";
    }

    @RequestMapping("/commuting/mat")
    public String parentslist(){
        return "thymeleaf/commuting/commuting_mat";
    }
}
