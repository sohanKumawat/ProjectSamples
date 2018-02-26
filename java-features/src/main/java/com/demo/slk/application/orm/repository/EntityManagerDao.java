package com.demo.slk.application.orm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.slk.application.orm.entity.mapping.bi.Professor;
import com.demo.slk.application.orm.entity.mapping.bi.Student;
import com.demo.slk.application.orm.entity.mapping.bi.University;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Repository
@Slf4j
public class EntityManagerDao {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unused")
	public void entityManagerOperation() {

		/*
		 * University univer = new University(); univer.setName("SLK Kumawat");
		 */
		// entityManager.persist(univer);

		University univer = entityManager.find(University.class, 1L);
		try {
			List<Student> studetns=univer.getStudents();
			List<Professor> professors=univer.getProfessors();
		} catch (Exception ex) {
			log.error("Sql Exception ** "+ex.getMessage());
		}
		Student stu = new Student();
		stu.setFirstName("sohan kumawat13");
		stu.setUniversity(univer);

		Professor prof = new Professor();
		prof.setName("SLK Kumawat13");
		prof.setUniversity(univer);

		entityManager.persist(prof);

		entityManager.persist(stu);

		/*
		 * Category category = new Category(); category.setName("Java");
		 * 
		 * Article article = new Article(); article.setTitle("Java title");
		 * article.setCategory("Java Category");
		 * 
		 * //Set<Article> articleSet = new HashSet<>();
		 * //articleSet.add(article); article.setCategor(category);
		 * //category.setArticles(articleSet);
		 * 
		 * entityManager.persist(article); Article fArticle=
		 * entityManager.find(Article.class, 4); University sUniv =
		 * entityManager.find(University.class, 4L);
		 */

		// log.info(" Student " + sUniv.toString());
	}
}
