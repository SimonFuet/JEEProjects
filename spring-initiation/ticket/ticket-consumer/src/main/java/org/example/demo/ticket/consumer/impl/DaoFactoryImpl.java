package org.example.demo.ticket.consumer.impl;

import javax.inject.Inject;

import org.example.demo.ticket.consumer.contract.DaoFactory;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;

public class DaoFactoryImpl implements DaoFactory {

	@Inject
	private TicketDao ticketDao;

	@Override
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	@Override
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

}
