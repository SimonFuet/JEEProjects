package org.example.demo.ticket.business.impl;

import javax.inject.Inject;

import org.example.demo.ticket.business.contract.ManagerFactory;
import org.example.demo.ticket.business.contract.manager.ProjetManager;
import org.example.demo.ticket.business.contract.manager.TicketManager;

public class ManagerFactoryImpl implements ManagerFactory {

	@Inject
	private ProjetManager projetManager;
	@Inject
	private TicketManager ticketManager;

	@Override
	public ProjetManager getProjetManager() {
		return projetManager;
	}

	@Override
	public void setProjetManager(ProjetManager projetManager) {
		this.projetManager = projetManager;
	}

	@Override
	public TicketManager getTicketManager() {
		return ticketManager;
	}

	@Override
	public void setTicketManager(TicketManager ticketManager) {
		this.ticketManager = ticketManager;
	}

}
