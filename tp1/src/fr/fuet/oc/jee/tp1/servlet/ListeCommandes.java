package fr.fuet.oc.jee.tp1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListeCommandes extends HttpServlet {
	public static final String ATT_COMMANDE = "commande";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/listerCommandes.jsp";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}