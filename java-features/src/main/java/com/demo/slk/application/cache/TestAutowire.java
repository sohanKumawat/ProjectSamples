package com.demo.slk.application.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class TestAutowire {
@Autowired
private  Environment env;

public  String apiUrl(String apiId){
	return env.getProperty("api.id.12", "hello");
}
}
