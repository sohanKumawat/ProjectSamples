package com.mb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.cron.JobScheduledEntity;

@Repository
public interface JobRepository extends JpaRepository<JobScheduledEntity, Long>{
public JobScheduledEntity findByNameIgnoreCase(String name) ;
}
