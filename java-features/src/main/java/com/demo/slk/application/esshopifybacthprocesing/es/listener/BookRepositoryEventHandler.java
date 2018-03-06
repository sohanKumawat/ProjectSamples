package com.demo.slk.application.esshopifybacthprocesing.es.listener;

import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import com.demo.slk.application.esshopifybacthprocesing.es.entity.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RepositoryEventHandler (Book.class)
public class BookRepositoryEventHandler {

	@HandleBeforeCreate
	public void handleBeforeCreate(Book book) {
		
		log.debug("handling before create for " + book.toString());
	}

	@HandleAfterSave
	public void handleAfterSave(Book book) {
		log.debug("saved book #" + book.getId());
	}

	@HandleAfterDelete
	public void handleAfterDelete(Book book) {
		log.debug("deleted book #" + book.getId());
	}
}