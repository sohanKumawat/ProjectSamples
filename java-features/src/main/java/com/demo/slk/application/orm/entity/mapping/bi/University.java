package com.demo.slk.application.orm.entity.mapping.bi;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UNIVERSITY_ID")
	private long id;

	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "university",targetEntity=Student.class)
	public List<Student> students;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "university",targetEntity=Professor.class)
	public List<Professor> professors;

}
