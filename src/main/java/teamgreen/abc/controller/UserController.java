package teamgreen.abc.controller;

import teamgreen.abc.domain.User1;
import teamgreen.abc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@Valid
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String signIn() {
            return "thymeleaf/loginOK";
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "thymeleaf/signup";
    }

    @RequestMapping("/signUp/create")
    public String create(User1 user) {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);      // 비밀번호 암호화
        userRepository.save(user);
        return "thymeleaf/login";
    }

    // 비밀번호 찾기 폼
    @RequestMapping(value = "/find_pw_form.do")
    public String find_pw_form() throws Exception{
        return "thymeleaf/find_pw_form";
    }


}