package com.demo.slk.application.orm.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Book extends MyProduct {
	private String author;

}