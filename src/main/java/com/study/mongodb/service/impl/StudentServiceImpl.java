package com.study.mongodb.service.impl;

import com.study.mongodb.entity.Student;
import com.study.mongodb.service.StudentService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: renjiahui
 * @date: 2021-03-29 23:33
 * @description:
 */
@Component
public class StudentServiceImpl implements StudentService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Student student) {

        mongoTemplate.save(student);
    }

    @Override
    public void update(Student student) {
        //条件
        Query query = new Query(Criteria.where("_id").is(student.getId()));

        //修改的内容
        Update update = new Update();
        update.set("content", student.getContent());
        update.set("userid", student.getUserid());
        update.set("name", student.getName());
        update.set("visits", student.getVisits());
        mongoTemplate.updateFirst(query, update, Student.class);
    }

    @Override
    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public void delete(String id) {
        Student student = mongoTemplate.findById(id, Student.class);
        mongoTemplate.remove(student);
    }
}
