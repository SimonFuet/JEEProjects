package fr.fuet.oc.jee.tp1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.fuet.oc.jee.tp1.bean.Client;
import fr.fuet.oc.jee.tp1.bean.Commande;

/**
 * Servlet implementation class CreationClient
 */
public class CreationCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CreationCommande() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasMissingParameters = false;

		Client client = new Client();
		if (request.getParameter("nomClient").isEmpty()) {
			hasMissingParameters = true;
		} else {
			client.setNom(request.getParameter("nomClient"));
		}
		client.setPrenom(request.getParameter("prenomClient"));
		if (request.getParameter("adresseClient").isEmpty()) {
			hasMissingParameters = true;
		} else {
			client.setAdresse(request.getParameter("adresseClient"));
		}
		if (request.getParameter("telephoneClient").isEmpty()) {
			hasMissingParameters = true;
		} else {
			client.setNumTel(request.getParameter("telephoneClient"));
		}
		client.setEmail(request.getParameter("emailClient"));

		Commande commande = new Commande();
		commande.setClient(client);
		commande.setDate("Today");
		if (request.getParameter("montantCommande").isEmpty()) {
			hasMissingParameters = true;
		} else {
			commande.setMontant(Double.parseDouble(request.getParameter("montantCommande")));
		}
		if (request.getParameter("modePaiementCommande").isEmpty()) {
			hasMissingParameters = true;
		} else {
			commande.setModePaiement(request.getParameter("modePaiementCommande"));
		}
		commande.setStatutPaiement(request.getParameter("statutPaiementCommande"));

		if (request.getParameter("modeLivraisonCommande").isEmpty()) {
			hasMissingParameters = true;
		} else {
			commande.setModeLivraison(request.getParameter("modeLivraisonCommande"));
		}
		commande.setStatutLivraison(request.getParameter("statutLivraisonCommande"));

		request.setAttribute("commande", commande);
		request.setAttribute("message", hasMissingParameters ? "Echec" : "Succès");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/afficherCommande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
