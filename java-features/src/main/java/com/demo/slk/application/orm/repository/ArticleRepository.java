package com.demo.slk.application.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.slk.application.orm.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>  {
  /*  List<Article> findByTitle(String title);
    List<Article> findDistinctByCategory(String category);
    List<Article> findByTitleAndCategory(String title, String category);

    @Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
    List<Article> fetchArticles(@Param("title") String title, @Param("category") String category);*/
} 
