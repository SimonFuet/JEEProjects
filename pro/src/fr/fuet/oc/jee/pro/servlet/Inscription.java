package fr.fuet.oc.jee.pro.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription extends HttpServlet {
	public static final String VUE = "/WEB-INF/inscription.jsp";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_PASS = "motdepasse";
	public static final String CHAMP_CONF = "confirmation";
	public static final String CHAMP_NOM = "nom";
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resultat;
		Map<String, String> erreurs = new HashMap<>();
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_PASS);
		String confirmation = request.getParameter(CHAMP_CONF);
		String nom = request.getParameter(CHAMP_NOM);

		try {
			validationEmail(email);
		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		try {
			validationMotsDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS, e.getMessage());
		}
		try {
			validationNom(nom);
		} catch (Exception e) {
			erreurs.put(CHAMP_NOM, e.getMessage());
		}

		if (erreurs.isEmpty()) {
			resultat = "Succ�s de l'inscription.";
		} else {
			resultat = "�chec de l'inscription.";
		}

		request.setAttribute(ATT_RESULTAT, resultat);
		request.setAttribute(ATT_ERREURS, erreurs);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * Valide l'adresse mail saisie.
	 */
	private void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
				&& confirmation.trim().length() != 0) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entr�s sont diff�rents, merci de les saisir � nouveau.");
			} else if (motDePasse.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caract�res.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	/**
	 * Valide le nom d'utilisateur saisi.
	 */
	private void validationNom(String nom) throws Exception {
		if (nom != null && !nom.isEmpty() && nom.trim().length() < 3) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caract�res.");
		}
	}
}