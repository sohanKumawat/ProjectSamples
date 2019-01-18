package com.mb.demo.beans.ticket;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class NAProductTicket extends TicketLogging implements Serializable {
	private static final long serialVersionUID = 6016282106850672550L;
	private long productId;
	private String hubId;
	private String sheet;
}
