package kiy3035.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageCotroller {
    @RequestMapping("/myPage")
    public String myPage(){
        return "mypage/mypage";
    }
}
