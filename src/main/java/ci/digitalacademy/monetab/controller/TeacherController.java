package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Teacher;

import ci.digitalacademy.monetab.services.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public String loadSection( Model model) {
        log.debug("Request to show teachers list");
        final List<Teacher> finalTeachers = teacherService.findAll();
        model.addAttribute("teachers", finalTeachers);
        model.addAttribute("teacher",new Teacher());

        long teacherCount = teacherService.countTeachers();
        model.addAttribute("teacherCount", teacherCount);
        return "teacher/list";
    }
    @GetMapping("/formTeacher")
    public String showTeacherForm(Model model){
        log.debug("");
        model.addAttribute("teacher", new Teacher());
        return "teacher/form";
    }
    @PostMapping
    public String saveTeacher(Teacher teacher,Model model){
        log.debug("Request to save teacher");
        teacher.setDateCreation(Instant.now());
        teacherService.save(teacher);
        model.addAttribute("message", "Professeur ajouté avec succès!");
        //return "redirect:/teachers";
        return "dashboard/home";
    }



}
