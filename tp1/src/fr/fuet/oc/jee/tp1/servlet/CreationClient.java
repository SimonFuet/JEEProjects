package fr.fuet.oc.jee.tp1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.fuet.oc.jee.tp1.bean.Client;

/**
 * Servlet implementation class CreationClient
 */
public class CreationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CreationClient() {
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

		request.setAttribute("client", client);
		request.setAttribute("message", hasMissingParameters ? "Echec" : "Succès");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/afficherClient.jsp").forward(request, response);
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
