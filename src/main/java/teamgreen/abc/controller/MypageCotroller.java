package teamgreen.abc.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import teamgreen.abc.repository.HelperRepository;


import java.security.Principal;

@Controller
public class MypageCotroller {
    private final HelperRepository helperRepository;

    public MypageCotroller(HelperRepository helperRepository) {
        this.helperRepository = helperRepository;
    }

    @RequestMapping("/myPage")
    public String myPage(Principal principal,Model model){

        String aa = principal.getName();
        String bb = principal.toString();
        model.addAttribute("aa",aa);
        model.addAttribute("bb",bb);
        if(helperRepository.findByHelperid(aa)!=null){
            System.out.println("헬퍼에도 똑같이 있음!!");
        }
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
