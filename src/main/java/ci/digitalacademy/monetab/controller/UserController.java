package ci.digitalacademy.monetab.controller;


import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public String loadSection( Model model) {
        log.debug("Request to show user list");
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "user/list";
    }


    @GetMapping("/formUser")
    public String showTeacherForm(Model model){
        log.debug("");
        model.addAttribute("user", new User());
        return "user/form";
    }

}
