package com.study.mongodb.service;

import com.study.mongodb.entity.Student;

import java.util.List;

/**
 * @author: renjiahui
 * @date: 2021-03-29 23:32
 * @description:
 */
public interface StudentService {

    void save(Student student);

    void update(Student student);

    List<Student> findAll();

    void delete(String id);
}
