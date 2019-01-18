package com.mb.demo.beans.ticket;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.mb.demo.constants.PickPackConstants.TicketType;
import com.mb.demo.entity.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class TicketLogging extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(unique = true)
	private String name;
	private TicketType type;
	private String description;
    
}
