package org.example.demo.ticket.business.contract.manager;

import java.util.List;

import org.example.demo.ticket.model.bean.ticket.Commentaire;
import org.example.demo.ticket.model.bean.ticket.HistoriqueStatut;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

public interface TicketManager {

	Ticket getTicket(Long pNumero) throws NotFoundException;

	List<Ticket> getListTicket(RechercheTicket pRechercheTicket);

	int getCountTicket(RechercheTicket pRechercheTicket);

	HistoriqueStatut changerStatut(Ticket ticket, TicketStatut newStatut, Utilisateur utilisateur,
			Commentaire commentaire) throws TechnicalException;

}
