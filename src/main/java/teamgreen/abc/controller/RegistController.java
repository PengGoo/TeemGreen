package teamgreen.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RegistController {
    @RequestMapping("/register/children")
    public String children(){
        return "thymeleaf/register/children";
    }

    @RequestMapping("/register/helper")
    public String helper(){
        return "thymeleaf/register/helper";
    }

}

