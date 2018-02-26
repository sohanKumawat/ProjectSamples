package com.demo.slk.application.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.slk.application.orm.entity.mapping.bi.University;

public interface UniversityRepository extends JpaRepository<University, Long>  {

}
