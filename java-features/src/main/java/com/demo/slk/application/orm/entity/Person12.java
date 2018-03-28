package com.demo.slk.application.orm.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class Person12 {
 
    @Id
    private long personId;
    private String name;
}