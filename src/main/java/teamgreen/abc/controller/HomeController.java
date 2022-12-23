package teamgreen.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/loginForm")
    public String home() {
        return "thymeleaf/login";
    }

    @GetMapping(value = "/users/join")      // 실험용
    public String login() {

        return "thymeleaf/loginOK";
    }

    @RequestMapping("/search")
    public String search() {
        return "thymeleaf/search/search";
    }

    @RequestMapping("/t")
    public String t() {
        return "thymeleaf/mypage/test";
    }
}
