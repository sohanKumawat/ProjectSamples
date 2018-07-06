package com.mb.demo.redis.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HubTeamClusterRespository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> hubTeamClusterData() {
		String sql = "select tc.team_id,tc.cluster_id , ch.hub_id from team_cluster tc , "
				+ " (select h.id as hub_id, c.id as c_id from hub h, clusters c where c.hub_id=h.id "
				+ " and h.flag=1 and c.flag=1) as ch where tc.cluster_id= ch.c_id  order by hub_id,team_id";
		List<Map<String, Object>> mapResult = jdbcTemplate.queryForList(sql);
		return mapResult;
	}

	public List<Map<String, Object>> hubTeamClusterData(long hubId) {
		String sql = "select tc.team_id,tc.cluster_id , ch.hub_id from team_cluster tc , "
				+ " (select h.id as hub_id, c.id as c_id from hub h, clusters c where c.hub_id=h.id "
				+ " and h.flag=1 and c.flag=1 and h.id=" + hubId
				+ ") as ch where tc.cluster_id= ch.c_id  order by hub_id,team_id";
		List<Map<String, Object>> mapResult = jdbcTemplate.queryForList(sql);
		return mapResult;
	}

	public List<Map<String, Object>> hubTeamClusterData(long hubId, long teamId) {
		String sql = "select tc.team_id,tc.cluster_id , ch.hub_id from team_cluster tc , "
				+ " (select h.id as hub_id, c.id as c_id from hub h, clusters c where c.hub_id=h.id "
				+ " and h.flag=1 and c.flag=1 and h.id=" + hubId
				+ ") as ch where tc.cluster_id= ch.c_id and tc.team_id=" + teamId + " order by hub_id,team_id";
		List<Map<String, Object>> mapResult = jdbcTemplate.queryForList(sql);
		return mapResult;
	}

}
