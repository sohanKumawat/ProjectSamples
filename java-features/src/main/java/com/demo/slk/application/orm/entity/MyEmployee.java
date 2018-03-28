package com.demo.slk.application.orm.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class MyEmployee extends Person12 {
    private String company;
    // constructor, getters, setters 
}
