package kiy3035.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommutingCotroller {


    @RequestMapping("/commuting/helperList")
    public String helperList(){
        return "commuting/helperlist";
    }

    @RequestMapping("/commuting/parentsList")
    public String parentslist(){
        return "commuting/parentslist";
    }
}
