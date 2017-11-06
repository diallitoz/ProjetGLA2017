package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import dao.ClientDaoImplementation;
import dao.CompteDaoImplementation;
import dao.IClientDao;
import dao.ICompteDao;
import dao.IUtilisateurDao;
import dao.SingletonConnexion;
import dao.UtilisateurDaoImplementation;
import metier.entities.Client;
import metier.entities.Compte;
import metier.entities.Utilisateur;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.php" }) // Deployement
																	// du
																	// controleur
																	// par
																	// ANOTATIONS!!!

public class ControleurServlet extends HttpServlet {

	private ICompteDao metier;
	private IClientDao metier2;
	private IUtilisateurDao metier3;

	@Override
	public void init() throws ServletException {
		metier = new CompteDaoImplementation();
		// Couplage fort. Pour gerer cela, on peut utiliser un Framework (Spring) pour gerer
		//les injections...
		metier2 = new ClientDaoImplementation();
		metier3 = new UtilisateurDaoImplementation();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();// Pour recuperer l'action
												// effectuee par l'user

		if (path.equals("/index.php")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		else if (path.equals("/ChercherCompte.php")) {
			String motCle = request.getParameter("motCle");
			CompteModele modeleCpte = new CompteModele();
			modeleCpte.setMotCle(motCle);
			List<Compte> listeCompteRecherche = metier.rechercherCompte("%" + motCle + "%");
			// Les "%" c'est pour signifier tt ce qui vient avant et apres le
			// mot cle
			modeleCpte.setListeCompteRecherche(listeCompteRecherche);
			
			request.setAttribute("modeleCpte", modeleCpte);
			request.getRequestDispatcher("VueCompte.jsp").forward(request, response);
		} 
		
		else if (path.equals("/ConsulterCompte.php")) {
			Long idClient = Long.parseLong(request.getParameter("idClient"));
			CompteModele modeleCpte = new CompteModele();
			modeleCpte.setIdClient(idClient);
			Compte compte = metier.consulterCompte(idClient);
			modeleCpte.setCompte(compte);
			//request.setAttribute("modeleCpte", modeleCpte);
			request.setAttribute("compte", compte);
			NumberFormat numberFormat = NumberFormat.getInstance(java.util.Locale.ENGLISH);
			request.setAttribute("soldeString", numberFormat.format(compte.getSolde())); 
			request.setAttribute("date", new Date());
			request.getRequestDispatcher("ConsulterCompte.jsp").forward(request, response);
		} 
		
		else if (path.equals("/CreerCompte.php")) {
			request.setAttribute("compte", new Compte());
			request.getRequestDispatcher("CreerNouveauCompte.jsp").forward(request, response);
		}

		else if (path.equals("/EnregistrerCompte.php") && request.getMethod().equals("POST")) {
			String type = request.getParameter("type");
			String date = request.getParameter("date");
			Long idClient = Long.parseLong(request.getParameter("idClient"));
			Long idGestionnaire = Long.parseLong(request.getParameter("idGestionnaire"));
			Double solde = Double.parseDouble(request.getParameter("solde"));

			Compte cpte = metier.enregistrerCompte(new Compte(type, date, idClient, idGestionnaire, solde));
			request.setAttribute("compte", cpte);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);

		}

		else if (path.equals("/SupprimerCompte.php")) {
			// Pour la suppression, il faut normalement utiliser la methode POST &&
			// request.getMethod().equals("POST")

			Long id = Long.parseLong(request.getParameter("id"));
			metier.supprimerCompte(id);
			response.sendRedirect("ChercherCompte.php?motCle=");
			// Redirection vers une autre page...

		}

		else if (path.equals("/ModifierCompte.php")) {

			Long id = Long.parseLong(request.getParameter("id"));
			Compte cpte = metier.getCompte(id);
			request.setAttribute("compte", cpte);
			request.getRequestDispatcher("ModifierCompte.jsp").forward(request, response);
			// response.sendRedirect("chercher.php?motCle=");// Redirection vers
			// une autre page...

		}

		else if (path.equals("/ModificationCompte.php") && request.getMethod().equals("POST")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String type = request.getParameter("type");
			String date = request.getParameter("date");
			Long idClient = Long.parseLong(request.getParameter("idClient"));
			Long idGestionnaire = Long.parseLong(request.getParameter("idGestionnaire"));
			Double solde = Double.parseDouble(request.getParameter("solde"));

			Compte cpte = new Compte(type, date, idClient, idGestionnaire, solde);

			cpte.setId(id);
			cpte = metier.modifierCompte(cpte);

			request.setAttribute("compte", cpte);
			request.getRequestDispatcher("ConfirmationModification.jsp").forward(request, response);

		}

		else if (path.equals("/DebiterCompte.php")) {

			Long id = Long.parseLong(request.getParameter("id"));
			Compte cpte = metier.getCompte(id);
			request.setAttribute("compte", cpte);
			request.setAttribute("date", new Date());
			request.getRequestDispatcher("DebiterCompte.jsp").forward(request, response);
			// response.sendRedirect("chercher.php?motCle=");// Redirection vers
			// une autre page...

		}

		else if (path.equals("/VersementCompte.php") && request.getMethod().equals("POST")) {
			
			//String date = request.getParameter("date");
			Long id = Long.parseLong(request.getParameter("id"));
			
			Double montant = Double.parseDouble(request.getParameter("montant"));

			Compte cpte = new Compte();

			cpte.setId(id);
			//cpte.setId(solde);
			cpte = metier.debiterCompte(cpte.getId(),montant, new Date());

			request.setAttribute("compte", cpte);
			request.setAttribute("montant", montant);
			request.setAttribute("date", new Date());
			request.getRequestDispatcher("ConfirmationVersement.jsp").forward(request, response);

		}
		
		
		//Operations sur l'entite CLIENT a travers l'objet METIER2
		
		
		else if (path.equals("/ChercherClient.php")) {
			String motCle = request.getParameter("motCle");
			ClientModele modeleClient = new ClientModele();
			modeleClient.setMotCle(motCle);
			List<Client> listeClientRecherche = metier2.rechercherClient("%" + motCle + "%");
			// Les "%" c'est pour signifier tt ce qui vient avant et apres le mot cle
			modeleClient.setListeClientRecherche(listeClientRecherche);
			request.setAttribute("modeleClient", modeleClient);
			request.getRequestDispatcher("VueClient.jsp").forward(request, response);
		} 
		
		
		else if (path.equals("/CreerClient.php")) {
			request.setAttribute("client", new Client());
			request.getRequestDispatcher("CreerNouveauClient.jsp").forward(request, response);
		}

		else if (path.equals("/EnregistrerClient.php") && request.getMethod().equals("POST")) {
			String civilite = request.getParameter("civilite");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String dateNaissance = request.getParameter("dateNaissance");
			String lieuNaissance = request.getParameter("lieuNaissance");
			String sexe = request.getParameter("sexe");
			String type = request.getParameter("type");
			String pieceIdentite = request.getParameter("pieceIdentite");
			String refPieceIdentite = request.getParameter("refPieceIdentite");
			String adresse = request.getParameter("adresse");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");

			Client client = metier2.enregistrerClient(new Client(civilite, nom, prenom, dateNaissance, lieuNaissance,
					sexe, type, pieceIdentite, refPieceIdentite, adresse, telephone, email));
			request.setAttribute("client", client);
			request.getRequestDispatcher("ConfirmationCreationClient.jsp").forward(request, response);

		}
		
		else if (path.equals("/ModifierClient.php")) {

			Long id = Long.parseLong(request.getParameter("id"));
			Client client = metier2.getClient(id);
			request.setAttribute("client", client);
			request.getRequestDispatcher("ModifierClient.jsp").forward(request, response);
			// response.sendRedirect("chercher.php?motCle=");// Redirection vers
			// une autre page...

		}

		else if (path.equals("/ModificationClient.php") && request.getMethod().equals("POST")) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			String civilite = request.getParameter("civilite");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String dateNaissance = request.getParameter("dateNaissance");
			String lieuNaissance = request.getParameter("lieuNaissance");
			String sexe = request.getParameter("sexe");
			String type = request.getParameter("type");
			String pieceIdentite = request.getParameter("pieceIdentite");
			String refPieceIdentite = request.getParameter("refPieceIdentite");
			String adresse = request.getParameter("adresse");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");

			Client client = new Client(civilite, nom, prenom, dateNaissance, lieuNaissance,
					sexe, type, pieceIdentite, refPieceIdentite, adresse, telephone, email);

			client.setId(id);
			
			client = metier2.modifierClient(client);

			request.setAttribute("client", client);
			request.getRequestDispatcher("ConfirmationModificationClient.jsp").forward(request, response);

		}
		
		else if (path.equals("/SupprimerClient.php")) {
			// Pour la suppression, il faut normalement utiliser la methode POST && request.getMethod().equals("POST")

			Long id = Long.parseLong(request.getParameter("id"));
			metier2.supprimerClient(id);
			response.sendRedirect("ChercherClient.php?motCle=");// Redirection vers uneautre page...

		}
		
		
		//Operations sur l'entite UTILISATEUR a travers l'objet METIER3
		
		
		else if (path.equals("/ChercherUtilisateur.php")) {
			String motCle = request.getParameter("motCle");
			UtilisateurModele modeleUser = new UtilisateurModele();
			modeleUser.setMotCle(motCle);
			List<Utilisateur> listeUserRecherche = metier3.rechercherUtilisateur("%" + motCle + "%");
			// Les "%" c'est pour signifier tt ce qui vient avant et apres le mot cle
			modeleUser.setListeUtilisateurRecherche(listeUserRecherche);
			request.setAttribute("modeleUser", modeleUser);
			request.getRequestDispatcher("VueUtilisateur.jsp").forward(request, response);
				} 
		
		else if (path.equals("/CreerUtilisateur.php")) {
			request.setAttribute("user", new Utilisateur());
			request.getRequestDispatcher("CreerNouveauUtilisateur.jsp").forward(request, response);
		}

		else if (path.equals("/EnregistrerUtilisateur.php") && request.getMethod().equals("POST")) {
			String profil = request.getParameter("profil");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			Boolean status = Boolean.parseBoolean(request.getParameter("status"));

			Utilisateur user = metier3.enregistrerUtilisateur(new Utilisateur(profil, login, password, email, status));
			request.setAttribute("user", user);
			request.getRequestDispatcher("ConfirmationCreationUtilisateur.jsp").forward(request, response);

		}
		
		else if (path.equals("/ModifierUtilisateur.php")) {

			Long id = Long.parseLong(request.getParameter("id"));
			Utilisateur user = metier3.getUtilisateur(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("ModifierUtilisateur.jsp").forward(request, response);
		}

		else if (path.equals("/ModificationUtilisateur.php") && request.getMethod().equals("POST")) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			String profil = request.getParameter("profil");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			Boolean status = Boolean.parseBoolean(request.getParameter("status"));

			Utilisateur user = new Utilisateur(profil, login, password, email, status);

			user.setId(id);
			
			user = metier3.modifierUtilisateur(user);

			request.setAttribute("user", user);
			request.getRequestDispatcher("ConfirmationModificationUtilisateur.jsp").forward(request, response);

		}		
		
		else if (path.equals("/SupprimerUtilisateur.php")) {
			// Pour la suppression, il faut normalement utiliser la methode POST && request.getMethod().equals("POST")

			Long id = Long.parseLong(request.getParameter("id"));
			metier3.supprimerUtilisateur(id);
			response.sendRedirect("ChercherUtilisateur.php?motCle=");// Redirection vers une autre page...

		}
		

		else if (path.equals("/controleurLogin.php")) {
			// Conroleur de l'affichage du MENU en fonction du Profil d'users...

			String loginUser = request.getParameter("login");
			String passwordUser = request.getParameter("password");
			
			String login="";
			String password="";
			String profil="";
			Boolean status=false;
			Long id=(long) 1000;
			
			
			Connection connexion = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			
			try {
				 connexion = SingletonConnexion.getConnexion();
				 ps = connexion.prepareStatement("SELECT * FROM UTILISATEUR WHERE LOGIN=? AND PASSWORD=?");
				ps.setString(1, loginUser);
				ps.setString(2, passwordUser);
				 rs = ps.executeQuery();
				if (rs.next()) {

					 profil = rs.getString("PROFIL");
					 login = rs.getString("LOGIN");
					 password = rs.getString("PASSWORD");
					 status = rs.getBoolean("STATUS");
					 id = rs.getLong("ID_UTILISATEUR");
				} else {
					 response.sendRedirect("index.jsp?id=wrong");
				}
				
				if (profil.equals("Administrateur") &&  status) {
					
					
					String sessionactivekey = "GH@45#";
					HttpSession session = request.getSession();
					session.setAttribute("skey", sessionactivekey);
					session.setAttribute("sLogin", login);
					session.setAttribute("sId", id);
					response.sendRedirect("Administration.jsp");
					
					
				}
				
				else if (profil.equals("Prestataire") &&  status) {
					
					
					String sessionactivekey = "GH@45#";
					HttpSession session = request.getSession();
					session.setAttribute("skey", sessionactivekey);
					session.setAttribute("sLogin", login);
					session.setAttribute("sId", id);
					response.sendRedirect("Prestataire.jsp");
					
					
				}
				
				else if (profil.equals("Gestionnaire") &&  status) {
					
					
					String sessionactivekey = "GH@45#";
					HttpSession session = request.getSession();
					session.setAttribute("skey", sessionactivekey);
					session.setAttribute("sLogin", login);
					session.setAttribute("sId", id);
					response.sendRedirect("Gestionnaire.jsp");
					
					
				}
				
				else if (profil.equals("Etudiant") &&  status) {
					
					
					String sessionactivekey = "GH@45#";
					HttpSession session = request.getSession();
					session.setAttribute("skey", sessionactivekey);
					session.setAttribute("sLogin", login);
					session.setAttribute("sId", id);
					response.sendRedirect("Etudiant.jsp");
					
					
				}
				
				else{
					 response.sendRedirect("index.jsp?id=wrong");
					
				}
				
			
			} catch (Exception e) {
				e.printStackTrace();
				 response.sendRedirect("index.jsp");
			} 
			

		}
		
		

		else {
			response.sendError(Response.SC_NOT_FOUND);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
