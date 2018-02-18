package com.demo.slk.application.orm.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class MyEmployee extends Person12 {
    private String company;
    // constructor, getters, setters 
}
