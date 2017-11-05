package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Utilisateur;

public class UtilisateurDaoImplementation implements IUtilisateurDao {

	@Override
	public Utilisateur enregistrerUtilisateur(Utilisateur user) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					"INSERT INTO UTILISATEUR (PROFIL, LOGIN, PASSWORD, EMAIL, STATUS) VALUES (?,?,?,?,?)");
			ps.setString(1, user.getProfil());
			ps.setString(2, user.getLogin());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setBoolean(5, user.getStatus());
			ps.executeUpdate();
			PreparedStatement ps2 = connexion.prepareStatement("SELECT MAX(ID_UTILISATEUR) AS MAX_ID FROM UTILISATEUR");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				user.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Utilisateur> rechercherUtilisateur(String motCle) {
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM UTILISATEUR WHERE PROFIL LIKE LOWER('%"+motCle+"%') OR LOGIN LIKE LOWER('%"+motCle+"%') OR STATUS LIKE LOWER('%"+motCle+"%')");
			
			ResultSet resultat = ps.executeQuery();
						
			while (resultat.next() ) {
				Utilisateur user = new Utilisateur();
				user.setId(resultat.getLong("ID_UTILISATEUR"));
				user.setProfil(resultat.getString("PROFIL"));
				user.setLogin(resultat.getString("LOGIN"));
				user.setPassword(resultat.getString("PASSWORD"));
				user.setEmail(resultat.getString("EMAIL"));
				user.setStatus(resultat.getBoolean("STATUS"));
				listUtilisateur.add(user);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUtilisateur;
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		Utilisateur user = null;
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM UTILISATEUR WHERE ID_UTILISATEUR=?");

			ps.setLong(1, id);
			ResultSet resultat = ps.executeQuery();
			if (resultat.next()) {
				user = new Utilisateur();
				
				 user.setId(resultat.getLong("ID_UTILISATEUR"));
				 user.setProfil(resultat.getString("PROFIL"));
				 user.setLogin(resultat.getString("LOGIN"));
				 user.setPassword(resultat.getString("PASSWORD"));
				 user.setEmail(resultat.getString("EMAIL"));
				 user.setStatus(resultat.getBoolean("STATUS"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	
	@Override
	public Utilisateur modifierUtilisateur(Utilisateur user) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					"UPDATE UTILISATEUR SET PROFIL=?,LOGIN=?, PASSWORD=?, EMAIL=?,STATUS=?"
					+ " WHERE ID_UTILISATEUR=?");
			
			 ps.setString(1, user.getProfil());
			 ps.setString(2, user.getLogin());
			 ps.setString(3, user.getPassword());
			 ps.setString(4, user.getEmail()); 
			 ps.setBoolean(5, user.getStatus());  
			 ps.setLong(6, user.getId());
			 ps.executeUpdate();
			 
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void supprimerUtilisateur(Long id) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("DELETE FROM UTILISATEUR WHERE ID_UTILISATEUR=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur consulterUtilisateur(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void envoyerMotDePasse(String email, String motDePasse) {
		// TODO Auto-generated method stub
		
	}

}
