package kiy3035.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@Controller
public class MypageCotroller {

    @RequestMapping("/myPage")
    public String myPage(Principal principal,Model model){
        String aa = principal.getName();
        model.addAttribute("aa",aa);

        return "thymeleaf/mypage/mypage";
    }

    @RequestMapping("/myPage/updateUser")
    public String updateUser(){
        return "thymeleaf/mypage/updateuser";
    }

    @RequestMapping("/myPage/updateHelper")
    public String updateHelper(){
        return "thymeleaf/mypage/updatehelper";
    }

    @RequestMapping("/myPage/updateParents")
    public String updateParents(){
        return "thymeleaf/mypage/updateparents";
    }
}
