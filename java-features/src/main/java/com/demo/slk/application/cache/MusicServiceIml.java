package com.demo.slk.application.cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@CacheConfig(cacheNames = {"directory", "instruments"})
@Slf4j
public class MusicServiceIml implements MusicService {


	@Autowired
	private Environment env;
	
	public String apiUrl(String apiId){
		return env.getProperty("api.id.12", "hello");
	}
	@Autowired
	TestAutowire test;
    @Cacheable(condition = "#instrument.equals('trombone')")
    public String play(String instrument) {
    	test.apiUrl("12");
    	log.info("12 "+apiUrl("12"));
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
        return "paying " + instrument + "!";
    }

}
