package org.example.demo.ticket.business;

import org.example.demo.ticket.business.manager.ProjetManager;
import org.example.demo.ticket.business.manager.TicketManager;

public class ManagerFactory {
	
	private ProjetManager projetManager;
	private TicketManager ticketManager;

	public ProjetManager getProjetManager() {
		return projetManager;
	}
	
	public void setProjetManager(ProjetManager projetManager) {
		this.projetManager = projetManager;
	}
	
	public TicketManager getTicketManager() {
		return new TicketManager();
	}
	
	public void setTicketManager(TicketManager ticketManager) {
		this.ticketManager = ticketManager;
	}
	
}
