package fr.fuet.oc.jee.pro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.fuet.oc.jee.pro.bean.Utilisateur;
import fr.fuet.oc.jee.pro.form.InscriptionForm;

public class Inscription extends HttpServlet {
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/inscription.jsp";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Pr�paration de l'objet formulaire */
		InscriptionForm form = new InscriptionForm();

		/*
		 * Appel au traitement et � la validation de la requ�te, et r�cup�ration du bean
		 * en r�sultant
		 */
		Utilisateur utilisateur = form.inscrireUtilisateur(request);

		/* Stockage du formulaire et du bean dans l'objet request */
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, utilisateur);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}