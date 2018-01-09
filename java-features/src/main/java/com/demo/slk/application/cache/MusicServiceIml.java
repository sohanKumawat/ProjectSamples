package com.demo.slk.application.cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"directory", "instruments"})
public class MusicServiceIml implements MusicService {

    private static Logger log = LoggerFactory.getLogger(MusicServiceIml.class);

    @Cacheable(condition = "#instrument.equals('trombone')")
    public String play(String instrument) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
        return "paying " + instrument + "!";
    }

}
