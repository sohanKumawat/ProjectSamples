package com.demo.slk.application.elasticsearch;

import java.util.Map;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import com.demo.slk.application.elasticsearch.entity.Book;
import com.demo.slk.application.elasticsearch.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OnApplicationStart {
	public static int counter;
	@Autowired
    private ElasticsearchOperations es;

    @Autowired
    private BookService bookService;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		counter++;
		System.out.println("** Application start counter ** " + counter);
		
//		printElasticSearchInfo();

        bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));

        //fuzzey search
        Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));

        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");

        for(Book book:books.getContent()){
        	log.info("Book result ** "+book.toString());
        }

    }

    //useful for debug, print elastic search details
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch--");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("--ElasticSearch--");
    }
}
