package ru.work.forum.control;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.work.forum.model.User;
import ru.work.forum.service.UserService;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserService users;

    public RegControl(PasswordEncoder encoder, UserService users) {
        this.encoder = encoder;
        this.users = users;
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }

//    @PostMapping("/req")
    @RequestMapping(value = "/reg", method= RequestMethod.POST)
    public String regSave(@ModelAttribute("user") User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode(user.getPassword());

        user.setEnabled(true);
        user.setPassword(pwd);
        user.setUsername(user.getUsername());
        users.saveUser(user, "ROLE_ADMIN");
        return "login";
    }


}
