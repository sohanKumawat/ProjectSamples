package com.demo.slk.application.orm.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "petId")
public class Pet extends Animal {
    private String name;
}
