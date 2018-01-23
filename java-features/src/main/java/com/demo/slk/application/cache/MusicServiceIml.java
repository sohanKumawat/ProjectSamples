package com.demo.slk.application.cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"directory", "instruments"})
public class MusicServiceIml implements MusicService {

    private static Logger log = LoggerFactory.getLogger(MusicServiceIml.class);

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
