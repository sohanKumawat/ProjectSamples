package com.mb.demo.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.redis.beans.HubTeamOrderEntity;

@Repository
public interface HubTeamOrderRepository extends CrudRepository<HubTeamOrderEntity, String> {

}
