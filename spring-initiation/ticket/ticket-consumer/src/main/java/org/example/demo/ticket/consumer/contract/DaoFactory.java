package org.example.demo.ticket.consumer.contract;

import org.example.demo.ticket.consumer.contract.dao.TicketDao;

public interface DaoFactory {

	TicketDao getTicketDao();

	void setTicketDao(TicketDao ticketDao);

}
