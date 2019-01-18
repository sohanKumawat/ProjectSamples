package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.ticket.ProductPickerTicket;
import com.mb.demo.entity.common.ticket.TicketSource;
import com.mb.demo.entity.common.ticket.TicketTarget;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="na_item_process")
public class NAProductProcessTicket extends ProductPickerTicket implements Serializable {
	private static final long serialVersionUID = 7852437607737057367L;

	@NotBlank
	private String hubId;

	private String teamId;

	@NotBlank
	private String sheet;

	@NotBlank
	private OperationType operationType;

	private TicketSource ticketSource;
	private TicketTarget ticketTarget;

}
