package com.demo.slk.application.orm.entity.mapping.bi;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.demo.slk.application.orm.entity.Article;

import lombok.Data;
@Data
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private long id;
    
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CATEGORY_ARTICLE",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID")
    )
    private Set<Article> articles;
 
}