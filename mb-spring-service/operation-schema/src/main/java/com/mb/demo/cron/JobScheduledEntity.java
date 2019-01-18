package com.mb.demo.cron;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class JobScheduledEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4969837097820622612L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cronJobExpression;
	@Column(unique=true)
	private String name;
}
