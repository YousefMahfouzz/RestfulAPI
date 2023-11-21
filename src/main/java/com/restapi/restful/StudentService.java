package com.restapi.restful;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {
    private StudentRepositry studentRepositry;
    @Autowired
    public StudentService(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    public List<Students> getStudent () {
        return studentRepositry.findAll();
    }

    public void addStudent (Students student) {
        studentRepositry.save(student);
    }

    @Transactional
    public void updateStudent (Long studendId, String name, String email
    ) {
        Students std = studentRepositry.findById(studendId).orElseThrow(
                () -> new IllegalStateException("Student with id = " + studendId + "doesn't exists."));

        if (name != null && !name.isEmpty() && !name.equals(std.getName()))
            std.setName(name);

        if (email != null && !email.isEmpty() && !email.equals(std.getEmail()))
            std.setEmail(email);
    }

    public void deleteStudent (Long studendId) {
        studentRepositry.deleteById(studendId);
    }
}
