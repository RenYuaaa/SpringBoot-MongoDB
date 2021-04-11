package com.study.mongodb.controller;

import com.study.mongodb.entity.Student;
import com.study.mongodb.service.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: renjiahui
 * @date: 2021-03-29 23:44
 * @description:
 */
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/save")
    public void save(Student student) {
        studentService.save(student);
    }

    @PostMapping("/update")
    public void update(Student student) {

        studentService.update(student);
    }

    @GetMapping("/find")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @DeleteMapping("/delete")
    public void delete(String id) {
        studentService.delete(id);
    }
}
