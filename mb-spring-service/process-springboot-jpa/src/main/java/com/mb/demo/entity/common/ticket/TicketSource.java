package com.mb.demo.entity.common.ticket;

import java.io.Serializable;

import com.mb.demo.entity.common.Attributes;

import lombok.Data;

@Data
public class TicketSource implements Serializable {
	private static final long serialVersionUID = 3442398973572120303L;
	private long id;
	private String sourceId;
	private Attributes attribute;
}
