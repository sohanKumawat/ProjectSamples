package com.demo.slk.application.elasticsearch.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "books_search", type = "books")
public class Book {

	@Id
	private String id;
	private String title;
	private String author;
	private String releaseDate;
}
