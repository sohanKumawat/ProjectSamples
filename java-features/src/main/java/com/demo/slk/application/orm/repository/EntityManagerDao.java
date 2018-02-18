package com.demo.slk.application.orm.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.slk.application.orm.entity.Article;
import com.demo.slk.application.orm.entity.mapping.bi.Category;
import com.demo.slk.application.orm.entity.mapping.bi.University;

import lombok.extern.slf4j.Slf4j;
@Transactional
@Repository
@Slf4j
public class EntityManagerDao {
	@PersistenceContext
	private EntityManager entityManager;

	public void entityManagerOperation() {
		/*
		 * University univer = new University(); univer.setName("SLK Kumawat");
		 * entityManager.persist(univer);
		 * 
		 * University university=entityManager.find(University.class, 4L);
		 * 
		 * Student stu = new Student(); stu.setFirstName("sohan kumawat");
		 * stu.setUniversity(university);
		 * 
		 * Professor prof = new Professor(); prof.setName("SLK Kumawat");
		 * prof.setUniversity(university);
		 * 
		 * entityManager.persist(prof);
		 * 
		 * entityManager.persist(stu);
		 */

		Category category = new Category();
		category.setName("Java");
		
		Article article = new Article();
		article.setTitle("Java title");
		article.setCategory("Java Category");
		
		//Set<Article> articleSet = new HashSet<>();
		//articleSet.add(article);
		article.setCategor(category);
		//category.setArticles(articleSet);
		
		entityManager.persist(article);
		Article fArticle=	entityManager.find(Article.class, 4);
		University sUniv = entityManager.find(University.class, 4L);

		// log.info("** Student ** " + sUniv.toString());
	}
}
