package org.example.demo.ticket.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.springframework.jdbc.core.RowMapper;

public class TicketStatutRM implements RowMapper<TicketStatut> {
	@Override
	public TicketStatut mapRow(ResultSet rs, int rowNum) throws SQLException {
		TicketStatut ticketStatut = new TicketStatut(rs.getInt("id"));
		ticketStatut.setLibelle(rs.getString("libelle"));
		return ticketStatut;
	}
}