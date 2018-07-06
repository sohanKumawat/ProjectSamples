package com.mb.demo.redis.rowmapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class HubTeamClusterResultMapper {

	public Map<String, List<Integer>> getClustersByHub(List<Map<String, Object>> rowMap) {
		Map<String, List<Integer>> result = new HashMap<>();
		for (int i = 0; rowMap != null && i < rowMap.size(); i++) {
			try {
				Object val = null;
				String teamId = (val = rowMap.get(i).get("team_id")) != null ? val.toString() : null;
				String hubId = (val = rowMap.get(i).get("hub_id")) != null ? val.toString() : null;
				if (teamId != null && hubId != null) {
					String key = "#" + hubId + "#" + teamId;
					key = key.trim();
					String clusterId = (val = rowMap.get(i).get("cluster_id")) != null ? val.toString() : null;
					if (result.containsKey(key)) {
						if (clusterId != null) {
							List<Integer> cIds = result.get(key);
							cIds.add(Integer.valueOf(clusterId));
						}
					} else {
						if (clusterId != null) {
							List<Integer> cids = new ArrayList<>();
							cids.add(Integer.valueOf(clusterId));
							result.put(key, cids);
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
