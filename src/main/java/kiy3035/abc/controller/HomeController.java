package kiy3035.abc.controller;

import kiy3035.abc.domain.User1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @GetMapping("/loginForm")
    public String home() {
        return "login";
    }

    @GetMapping(value = "/users/join")      // 실험용
    public String login() {

        return "loginOK";
    }
    @RequestMapping("/search")
    public String search(){
        return "search/search";
    }
}

