package com.study.mongodb;

import com.study.mongodb.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

@SpringBootTest
class SpringBootMongoDbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void mongoTest() {
        Criteria criteria = Criteria.where("content").is("test333");
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project("content", "name", "userid"),
//                Aggregation.match(criteria),
                Aggregation.sort(Sort.Direction.DESC, "content"),
                Aggregation.group("userid")
                        .first("content").as("content")
                        .first("name").as("name")
                        .first("userid").as("userid"),
                Aggregation.skip(1*2L),
                Aggregation.limit(2)
        );
        AggregationResults<Student> aggregate = mongoTemplate.aggregate(aggregation, "student", Student.class);
        List<Student> list = aggregate.getMappedResults();
        System.out.println(list);

        Aggregation aggregation1 = Aggregation.newAggregation(
//                Aggregation.match(criteria),
                Aggregation.group("userid"),
                Aggregation.count().as("count")
        );
        AggregationResults<Student> student = mongoTemplate.aggregate(aggregation1, "student", Student.class);
        List<Student> result = student.getMappedResults();
        System.out.println(result.get(0).getCount());
    }

}
