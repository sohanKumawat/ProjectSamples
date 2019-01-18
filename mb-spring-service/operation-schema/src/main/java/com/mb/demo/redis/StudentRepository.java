package com.mb.demo.redis;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.redis.Student.Gender;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
	
	 List<Student> findByName(String name);
	 List<Student> findByGender(Gender gender);
	
	
	
}

