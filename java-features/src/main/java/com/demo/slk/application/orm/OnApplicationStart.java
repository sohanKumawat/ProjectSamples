package com.demo.slk.application.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.demo.slk.application.orm.repository.ArticleRepository;
import com.demo.slk.application.orm.repository.EntityManagerDao;
import com.demo.slk.application.orm.repository.MappingRepository;
import com.demo.slk.application.orm.util.RestClientUtil;

@Component
public class OnApplicationStart {
	public static int counter;
	@Autowired
	RestClientUtil util;
	@Autowired
	MappingRepository mappingRepo;
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	EntityManagerDao entityManagerDao;
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		counter++;
		System.out.println("** Application start counter ** "+counter);
		//Article article =Article.builder().category("Java programing").title("Java").build();
	//	articleRepository.save(article);
	//	mappingRepo.save(st);
		entityManagerDao.entityManagerOperation();
	}
	
}
