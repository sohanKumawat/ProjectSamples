package com.mb.demo.redis.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.redis.repository.HubTeamClusterRespository;
import com.mb.demo.redis.rowmapper.HubTeamClusterResultMapper;

@Service
public class HubTeamClusterService {

	@Autowired
	HubTeamClusterRespository HubTeamClusterRespo;
	@Autowired
	HubTeamClusterResultMapper hubTeamClusterResultMapper;

	public Map<String, List<Integer>> hubTeamClusterData() {
		List<Map<String, Object>> mapResult = HubTeamClusterRespo.hubTeamClusterData();
		Map<String, List<Integer>> hubTeamClusterList = hubTeamClusterResultMapper.getClustersByHub(mapResult);
		return hubTeamClusterList;
	}

	public Map<String, List<Integer>> hubTeamClusterData(long hubId, long teamId) {
		List<Map<String, Object>> mapResult = HubTeamClusterRespo.hubTeamClusterData(hubId, teamId);
		Map<String, List<Integer>> hubTeamClusterList = hubTeamClusterResultMapper.getClustersByHub(mapResult);
		return hubTeamClusterList;
	}

	public Map<String, List<Integer>> hubTeamClusterData(long hubId) {
		List<Map<String, Object>> mapResult = HubTeamClusterRespo.hubTeamClusterData(hubId);
		Map<String, List<Integer>> hubTeamClusterList = hubTeamClusterResultMapper.getClustersByHub(mapResult);
		return hubTeamClusterList;
	}

}
