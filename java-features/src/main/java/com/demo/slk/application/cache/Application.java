package com.demo.slk.application.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.demo.slk.application.cache.dozer.BeanAdapterHelper;
import com.demo.slk.application.cache.dozer.GenericOrder;
import com.demo.slk.application.cache.dozer.ShopifyOrder;
import com.google.gson.Gson;

@EnableCaching
@SpringBootApplication
public class Application implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private MusicService musicService;
	@Autowired
	private A a;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Spring Boot Caffeine Caching Example Configuration");

		play("trombone");
		play("guitar");
		play("trombone");
		play("bass");
		play("trombone");
	}

	private void play(String instrument) {
		log.info("Calling: " + MusicServiceIml.class.getSimpleName() + ".play(\"" + instrument + "\");");
		musicService.play(instrument);
		a.add();
		A.sadd();
		ShopifyOrder or = new ShopifyOrder();
		or.setName("sohan");
		or.setSal("21233e");
		GenericOrder gorder = BeanAdapterHelper.fromString(new Gson().toJson(or), ShopifyOrder.class,
				GenericOrder.class);
		System.out.println(gorder.toString());
	}

}
