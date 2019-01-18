package com.mb.demo.entity.common.ticket;

import java.io.Serializable;

import javax.persistence.Column;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.TicketType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TicketLogging extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(unique = true)
	private String ticketId;
	private String ticketName;
	private TicketType ticketType;
	private String ticketDescription;
    
}
