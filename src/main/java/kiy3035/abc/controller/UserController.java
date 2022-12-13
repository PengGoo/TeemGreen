package kiy3035.abc.controller;

import kiy3035.abc.domain.User1;
import kiy3035.abc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/createUserForm")
    public String createForm() {
        return "users/createuserform";
    }

    @PostMapping(value = "/users/signUp")
    public String create(UserForm form) {

        User1 user = new User1();
        user.setUser_id(form.getUser_id());
        user.setUser_age(form.getUser_age());
        user.setUser_pw(form.getUser_pw());
        user.setUser_name(form.getUser_name());
        user.setUser_tel(form.getUser_tel());
        user.setUser_comment(form.getUser_comment());
        user.setUser_profile(form.getUser_profile());
        user.setUser_kakao(form.getUser_kakao());


        userService.join(user);

        return "mainpage";
    }

    @GetMapping("/userList")
    public String list(Model model) {
        List<User1> users = userService.findUsers();
        model.addAttribute("users", users);
        return "users/userlist";
    }

}
