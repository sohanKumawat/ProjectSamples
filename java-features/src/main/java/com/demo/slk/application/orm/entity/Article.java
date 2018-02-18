package com.demo.slk.application.orm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.demo.slk.application.orm.entity.mapping.bi.Category;

import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "article_id")
	private int articleId;
	@Column(name = "title")
	private String title;
	@Column(name = "category")
	private String category;
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
	private Category categor;
}
