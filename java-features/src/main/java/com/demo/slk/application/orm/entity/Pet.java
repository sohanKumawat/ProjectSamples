package com.demo.slk.application.orm.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "petId")
public class Pet extends Animal {
    private String name;
}
