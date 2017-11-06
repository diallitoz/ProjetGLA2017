package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import metier.entities.Client;
import metier.entities.Compte;
import metier.entities.Utilisateur;

public class TestDao { 

	public static void main(String[] args) {
		CompteDaoImplementation dao = new CompteDaoImplementation();
		Compte cpte1 = dao.enregistrerCompte(new Compte("Prestataire", "2017.11.05", 5, 2, 100000.0));
		/*Compte cpte2 = dao.enregistrerCompte(new Compte("Etudiant", "2017.10.27", 2, 15, 1000000.0));
		Compte cpte3 = dao.enregistrerCompte(new Compte("Prestataire", "2017.10.27", 3, 1, 1000000.0));
		System.out.println(cpte1.toString());
		System.out.println(cpte2.toString());
		System.out.println(cpte3.toString());
		System.out.println("Chercher des comptes");
		List<Compte> listCompteRecherche = dao.rechercherCompte("%Etud%");
		for(Compte cpte : listCompteRecherche){
			System.out.println(cpte.toString());
		}*/
		
		System.out.println(cpte1.toString());
		
		cpte1 = dao.debiterCompte(cpte1.getId(), 1000000.0, "");
		
		System.out.println(cpte1.toString());
		
		/*NumberFormat numberFormat = NumberFormat.getInstance(java.util.Locale.FRENCH);
		
		Compte cpte = dao.consulterCompte((long)39);
		System.out.println(cpte.getIdClient());
		System.out.println(numberFormat.format(cpte.getSolde()));*/
		
		/*ClientDaoImplementation dao1 = new ClientDaoImplementation();
		Client client1 = dao1.enregistrerClient(new Client("M", "DIALLO","Azise", "1988.09.11", "Bobo", "M", "Etudiant","Passport","A111 du 11 Sep 2015","ky tuc xa My dinh","01665853416","diallo.p21@ifi.edu.vn"));
		System.out.println(client1.toString());
		Client client2 = dao1.enregistrerClient(new Client("M", "DIALLO","Azise Oumar", "1988.09.11", "Bobo", "M", "Etudiant","Passport","A111 du 11 Sep 2015","ky tuc xa My dinh","01665853416","diallo.p21@ifi.edu.vn"));
		System.out.println(client2.toString());
		Client client3 = dao1.enregistrerClient(new Client("M", "KOUADIO","Olivier", "1991.09.11", "YopCity", "M", "Etudiant","Passport","A111 du 11 Sep 2015","ky tuc xa My dinh","016698053416","kouadio.p21@ifi.edu.vn"));
		System.out.println(client3.toString());
		Client client4 = dao1.enregistrerClient(new Client("M", "KFANDO","Rodrique", "1993.09.11", "Ouaga", "M", "Etudiant","Passport","A111 du 11 Sep 2015","ky tuc xa My dinh","01665853416","kafando.p21@ifi.edu.vn"));
		System.out.println(client4.toString());
		Client client5 = dao1.enregistrerClient(new Client("M", "QUANG","Ngyen", "1940.09.11", "Bobo", "M", "Prestataire","Carte d'identite natioanle","Cp0011 du 11 Sep 2006","ky tuc xa My dinh","01669874416","quang@ifi.edu.vn"));
		System.out.println(client5.toString());*/
	/*	Connection connexion = SingletonConnexion.getConnexion();
		String motCle = "etu";
		String selectSQL = "SELECT * FROM CLIENT WHERE NOM LIKE LOWER('%"+motCle+"%') OR PRENOM LIKE LOWER('%"+motCle+"%') OR TYPE_CLIENT LIKE LOWER('%"+motCle+"%')";
				try {
					PreparedStatement preparedStatement = connexion.prepareStatement(selectSQL);
					ResultSet rs = preparedStatement.executeQuery(selectSQL );
					while (rs.next()) {
						String nom = rs.getString("NOM");
						String prenom = rs.getString("PRENOM");
						String type = rs.getString("TYPE_CLIENT");
					System.out.println(nom);
					System.out.println(prenom);
					System.out.println(type);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				UtilisateurDaoImplementation dao3 = new UtilisateurDaoImplementation();
				
				/*Utilisateur user1 = dao3.enregistrerUtilisateur(new Utilisateur("Administrateur", "popo", "popo","popo@gmail.com", false));
				System.out.println(user1.toString());*/
				/*Utilisateur user2 = dao3.enregistrerUtilisateur(new Utilisateur("Etudiant", "moto", "moto","moto@gmail.com", true));
				Utilisateur user3 = dao3.enregistrerUtilisateur(new Utilisateur("Prestataire", "pata", "pata","pata@gmail.com", false));
				
				System.out.println(user1.toString());
				System.out.println(user2.toString());
				System.out.println(user3.toString());*/
				
				//dao3.supprimerUtilisateur((long) 9);
				
				/*System.out.println("Chercher des utilisateurs");
				
				List<Utilisateur> listUserRecherche = dao3.rechercherUtilisateur("%%");
				for(Utilisateur user : listUserRecherche){
					System.out.println(user.toString());
				}*/
				
				
				
				
	}

}
