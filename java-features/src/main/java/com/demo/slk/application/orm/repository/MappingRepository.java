package com.demo.slk.application.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.slk.application.orm.entity.mapping.bi.Student;

@Transactional
@Repository
public interface MappingRepository extends JpaRepository<Student, Long> {
	
}
