package chinchulin.varano.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chinchulin.varano.Models.Student;
import chinchulin.varano.Models.Subject;
import chinchulin.varano.Services.Student.StudentService;
import jakarta.annotation.Nullable;

@RequestMapping("/api/student")
@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/active")
    public List<Student> getAllActive() {
        return service.getAllActive();
    }

    @GetMapping("/all")
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/get/subject/{id}")
    public List<Subject> getSubjectByStudent(@PathVariable Long id) {
        return service.getSubjectByStudent(id);
    }

    @GetMapping("get/dni/{dni}")
    public Student getByDNI(@PathVariable Long dni) {
        return service.getByDNI(dni);
    }

    @GetMapping("/get/legajo/{legajo}")
    public Student getByLegajo(@PathVariable Long legajo) {
        return service.getByLegajo(legajo);
    }

    @PostMapping("/add")
    public Student newStudent(@RequestBody Student student) {
        return service.newStudent(student);
    }

    @PutMapping("/edit/{id}")
    public Student editStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.editStudent(id, student);
    }

    @PutMapping("/inactive/{id}")
    public Student inactiveStudent(@PathVariable Long id) {
        return service.inactiveStudent(id);
    }

    @GetMapping("/all/filter")
    public List<Student> getByFilter(@RequestParam(name = "query", required = false) @Nullable String query,
            @RequestParam(name = "limit", required = true) Integer limit, @RequestParam(name = "limit", required = true) Integer offset ) {
        if (query == null || query.isEmpty()) {
            return service.getAll();
        }
        return service.getByFilterQuery(query, limit, offset);
    }
}
