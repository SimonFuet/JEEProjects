package org.example.demo.ticket.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.impl.rowmapper.TicketStatutRM;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class TicketDaoImpl extends AbstractDaoImpl implements TicketDao {

	@Override
	public int getCountTicket(RechercheTicket pRechercheTicket) {
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		StringBuilder vSQL = new StringBuilder("SELECT COUNT(*) FROM ticket WHERE 1=1");

		if (pRechercheTicket != null) {
			if (pRechercheTicket.getAuteurId() != null) {
				vSQL.append(" AND auteur_id = :auteur_id");
				vParams.addValue("auteur_id", pRechercheTicket.getAuteurId(), Types.INTEGER);
			}
			if (pRechercheTicket.getProjetId() != null) {
				vSQL.append(" AND projet_id = :projet_id");
				vParams.addValue("projet_id", pRechercheTicket.getProjetId(), Types.VARCHAR);
			}
		}

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		int vNbrTicket = vJdbcTemplate.queryForObject(vSQL.toString(), vParams, Integer.class);

		return vNbrTicket;
	}

	@Override
	public List<TicketStatut> getListStatut() {
		String sql = "SELECT * FROM statut";
		JdbcTemplate template = new JdbcTemplate(getDataSource());

		RowMapper<TicketStatut> rowMapper = new TicketStatutRM();

		return template.query(sql, rowMapper);
	}

	@Override
	public void updateTicketStatus(TicketStatut ticketStatus) {
		String sql = "UPDATE status SET libelle = :libelle WHERE id = :id";

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(ticketStatus);
		params.registerSqlType("id", Types.INTEGER);
		params.registerSqlType("libelle", Types.VARCHAR);

		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getDataSource());
		template.update(sql, params);
	}
}