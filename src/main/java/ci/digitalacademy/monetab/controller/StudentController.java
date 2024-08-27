package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String showStudentList(Model model) {
        final List<Student> finalStudent = studentService.findAll();
        model.addAttribute("students", finalStudent);
        model.addAttribute("student", new Student());

        long studentCount = studentService.countStudents();
        model.addAttribute("studentCount", studentCount);

        return "student/list";
    }

    @GetMapping("/formStudent")
    public String showStudentForm(Model model) {
        log.debug("");
        model.addAttribute("student", new Student());

        return "student/form";
    }

    @PostMapping
    public String saveStudent(Student student, Model model) {
        log.debug("Request to save student");
        student.setDateCreation(Instant.now());
        studentService.save(student);
        model.addAttribute("message", "Élève ajouté avec succès!");

        return "dashboard/home";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentService.findOne(id);
        if (student.isPresent()){
            model.addAttribute("student", student);
            return "student/form";
        }
        else {
            return "redirect:/students";
        }

    }

    @PostMapping("/update")
    public String updateStudent(Student student, Model model) {
        log.debug("Request to update student");
        studentService.update(student);
        model.addAttribute("message", "Élève mis à jour avec succès!");

        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        log.debug("Request to delete student");
        studentService.delete(id);
        model.addAttribute("message", "Élève supprimé avec succès!");

        return "redirect:/students";
    }
}
