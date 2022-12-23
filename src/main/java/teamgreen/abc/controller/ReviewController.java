package teamgreen.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
    @RequestMapping("/review/helper")
    public String reHelper(){
        return "thymeleaf/review/rehelper";
    }

    @RequestMapping("/review/parents")
    public String reParents(){
        return "thymeleaf/review/reparents";
    }
}
