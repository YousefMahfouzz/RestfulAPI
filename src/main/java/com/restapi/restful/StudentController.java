package com.restapi.restful;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path="/items")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Students> getStudent () {
        return studentService.getStudent();

    }
    @PostMapping
    public void addStudent (@RequestBody Students student) {
        studentService.addStudent(student);
    }
    @Transactional
    @PutMapping(path = "{stdId}")
    public void updateStudent (
            @PathVariable("stdId") Long studendId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
            ) {
        studentService.updateStudent(studendId, name, email);
    }
    @DeleteMapping(path = "{stdId}")
    public void deleteStudent (@PathVariable("stdId") Long studendId) {
        studentService.deleteStudent(studendId);
    }
}
