package com.demo.slk.application.orm.entity.mapping.bi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROFESSOR_ID")
	private long id;

	private String name;

	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "UNIVERSITY_ID")
	private University university;
	
}
