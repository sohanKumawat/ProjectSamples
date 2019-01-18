package com.mb.demo.entity.common.ticket;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NAProductTicket extends TicketLogging implements Serializable {
	private static final long serialVersionUID = 6016282106850672550L;
	private String productId;
	private String hubId;
	private String sheet;
}
