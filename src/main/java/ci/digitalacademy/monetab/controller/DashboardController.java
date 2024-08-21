package ci.digitalacademy.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public String showDashboard(){
        return "dashboard/dashboard";
    }

    @GetMapping("composant/{page}")
    public String loadSection(@PathVariable("page") String page) {
        return "dashboard/composant/" + page;
    }
}

