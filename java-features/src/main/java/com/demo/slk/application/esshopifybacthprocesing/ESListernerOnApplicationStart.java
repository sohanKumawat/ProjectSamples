package com.demo.slk.application.esshopifybacthprocesing;

import java.util.List;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.batch.PlatformDataReader1;
import com.demo.slk.application.esshopifybacthprocesing.es.entity.ClientInventoryHerarichy;
import com.demo.slk.application.esshopifybacthprocesing.es.entity.PlProductInventory;
import com.demo.slk.application.esshopifybacthprocesing.es.service.ClientInventoryHerarichyService;
import com.demo.slk.application.esshopifybacthprocesing.es.service.ProductInventoryService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ESListernerOnApplicationStart {

	public static int counter;
	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private PlatformDataReader1 platformDataReader1;
	@Autowired
	ProductInventoryService pInventroyService;

	@Autowired
	ClientInventoryHerarichyService clientInventoryHerarichyService;

	@SuppressWarnings("unused")
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		counter++;
		/*
		 * System.out.println("** Application start counter ** " + counter);
		 * bookService.save(new Book("1001", "Elasticsearch Basics",
		 * "Rambabu Posa", "23-FEB-2017")); bookService.save(new Book("1002",
		 * "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
		 * bookService.save(new Book("1003", "Apache Solr Basics",
		 * "Rambabu Posa", "21-MAR-2017"));
		 * 
		 * //fuzzey search Page<Book> books =
		 * bookService.findByAuthor("Rambabu", new PageRequest(0, 10));
		 * //List<Book> books = bookService.findByTitle("Elasticsearch Basics");
		 * for(Book book:books.getContent()){
		 * log.info("Book result ** "+book.toString()); }
		 */

		try {
			platformDataReader1.read();
			List<PlProductInventory> plProductInventory = pInventroyService.findByCategory("clothing",
					new PageRequest(0, 10));
			List<ClientInventoryHerarichy> clientInventoryHerarichy = clientInventoryHerarichyService
					.findByBotIdAndParentId("1232", "-1", new PageRequest(0, 10)).getContent();
			for (ClientInventoryHerarichy piherarichy : clientInventoryHerarichy) {
				try {
					List<PlProductInventory> pipInventory = pInventroyService
							.findByCategoryAndSubCategory1(piherarichy.getName(), "Shirt", new PageRequest(0, 10))
							.getContent();
				} catch (Exception ex) {
					log.error(ex.getMessage());
				}
			}
			log.info(plProductInventory.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// useful for debug, print elastic search details
	@SuppressWarnings("unused")
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
