package com.demo.slk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {
	ObjectMapper mapper=null;
  static{
	ObjectMapper mapper=new ObjectMapper();
	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
  }
}
