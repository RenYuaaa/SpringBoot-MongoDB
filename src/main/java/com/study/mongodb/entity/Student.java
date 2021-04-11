package com.study.mongodb.entity;

import lombok.Data;

/**
 * @author: renjiahui
 * @date: 2021-03-29 23:30
 * @description:
 */
@Data
public class Student {

    private String id;

    private String content;

    private String name;

    private String userid;

    private Integer visits;

    private Integer count;
}
