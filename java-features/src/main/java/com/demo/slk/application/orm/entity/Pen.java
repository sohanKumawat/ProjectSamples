package com.demo.slk.application.orm.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Pen extends MyProduct {
    private String color;
}
