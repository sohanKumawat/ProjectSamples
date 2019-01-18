package com.mb.demo.entity.common.ticket;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.ticket.ProductPickerTicket;
import com.mb.demo.beans.ticket.TicketSource;
import com.mb.demo.beans.ticket.TicketTarget;
import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="na_item_process")
public class NAProductProcessTicketEntity extends ProductPickerTicket implements Serializable {
	private static final long serialVersionUID = 7852437607737057367L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@NotBlank
	private String hubId;


	@NotBlank
	private String sheet;

	@NotBlank
	private OperationType operationType;

	private TicketSource ticketSource;
	private TicketTarget ticketTarget;

}
