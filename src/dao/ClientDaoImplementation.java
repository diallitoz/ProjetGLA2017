package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;

public class ClientDaoImplementation implements IClientDao {

	@Override
	public Client enregistrerClient(Client client) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					"INSERT INTO CLIENT (CIVILITE,NOM,PRENOM,DATE_NAISSANCE,LIEU_NAISSANCE,SEXE,TYPE_CLIENT,"
							+ "TYPE_PIECE_IDENTITE,REF_PIECE_IDENTITE,ADRESSE,TELEPHONE,EMAIL) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, client.getCivilite());
			ps.setString(2, client.getNom());
			ps.setString(3, client.getPrenom());
			ps.setString(4, client.getDateNaissance());
			ps.setString(5, client.getLieuNaissance());
			ps.setString(6, client.getSexe());
			ps.setString(7, client.getType());
			ps.setString(8, client.getPieceIdentite());
			ps.setString(9, client.getRefPieceIdentite());
			ps.setString(10, client.getAdresse());
			ps.setString(11, client.getTelephone());
			ps.setString(12, client.getEmail());
	
			ps.executeUpdate();
			PreparedStatement ps2 = connexion.prepareStatement("SELECT MAX(ID_CLIENT) AS MAX_ID FROM CLIENT");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				client.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Client> rechercherClient(String motCle) {
		List<Client> listClient = new ArrayList<Client>();
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM CLIENT WHERE NOM LIKE LOWER('%"+motCle+"%') OR PRENOM LIKE LOWER('%"+motCle+"%') OR TYPE_CLIENT LIKE LOWER('%"+motCle+"%')");
			//PreparedStatement ps2 = connexion.prepareStatement("SELECT * FROM CLIENT WHERE PRENOM LIKE ?");
			//PreparedStatement ps3 = connexion.prepareStatement("SELECT * FROM CLIENT WHERE TYPE_CLIENT LIKE ?");

			//ps.setString(1, motCle);
			//ps.setString(2, motCle);
			//ps.setString(3, motCle);
			//ps2.setString(1, motCle);
			//ps3.setString(1, motCle);
			
			ResultSet resultat = ps.executeQuery();
			//ResultSet resultat2 = ps2.executeQuery();
			//ResultSet resultat3 = ps3.executeQuery();
			
			while (resultat.next() ) {
				Client client = new Client();
				client.setId(resultat.getLong("ID_CLIENT"));
				client.setCivilite(resultat.getString("CIVILITE"));
				client.setNom(resultat.getString("NOM"));
				client.setPrenom(resultat.getString("PRENOM"));
				client.setDateNaissance(resultat.getString("DATE_NAISSANCE"));
				client.setLieuNaissance(resultat.getString("LIEU_NAISSANCE"));
				client.setSexe(resultat.getString("SEXE"));
				client.setType(resultat.getString("TYPE_CLIENT"));
				client.setPieceIdentite(resultat.getString("TYPE_PIECE_IDENTITE"));
				client.setRefPieceIdentite(resultat.getString("REF_PIECE_IDENTITE"));
				client.setAdresse(resultat.getString("ADRESSE"));
				client.setTelephone(resultat.getString("TELEPHONE"));
				client.setEmail(resultat.getString("EMAIL"));
				listClient.add(client);
			}
			
				
			/*	while (resultat2.next()) {
					Client client2 = new Client();
				client2.setId(resultat2.getLong("ID_CLIENT"));
				client2.setCivilite(resultat2.getString("CIVILITE"));
				client2.setNom(resultat2.getString("NOM"));
				client2.setPrenom(resultat2.getString("PRENOM"));
				client2.setDateNaissance(resultat2.getString("DATE_NAISSANCE"));
				client2.setLieuNaissance(resultat2.getString("LIEU_NAISSANCE"));
				client2.setSexe(resultat2.getString("SEXE"));
				client2.setType(resultat2.getString("TYPE_CLIENT"));
				client2.setPieceIdentite(resultat2.getString("TYPE_PIECE_IDENTITE"));
				client2.setRefPieceIdentite(resultat2.getString("REF_PIECE_IDENTITE"));
				client2.setAdresse(resultat2.getString("ADRESSE"));
				client2.setTelephone(resultat2.getString("TELEPHONE"));
				client2.setEmail(resultat2.getString("EMAIL"));
				listClient.add(client2);
				}
				
				while (resultat3.next()) {
				Client client3 = new Client();
				client3.setId(resultat3.getLong("ID_CLIENT"));
				client3.setCivilite(resultat3.getString("CIVILITE"));
				client3.setNom(resultat3.getString("NOM"));
				client3.setPrenom(resultat3.getString("PRENOM"));
				client3.setDateNaissance(resultat3.getString("DATE_NAISSANCE"));
				client3.setLieuNaissance(resultat3.getString("LIEU_NAISSANCE"));
				client3.setSexe(resultat3.getString("SEXE"));
				client3.setType(resultat3.getString("TYPE_CLIENT"));
				client3.setPieceIdentite(resultat3.getString("TYPE_PIECE_IDENTITE"));
				client3.setRefPieceIdentite(resultat3.getString("REF_PIECE_IDENTITE"));
				client3.setAdresse(resultat3.getString("ADRESSE"));
				client3.setTelephone(resultat3.getString("TELEPHONE"));
				client3.setEmail(resultat3.getString("EMAIL"));
				listClient.add(client3);
			}*/

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listClient;
	}

	@Override
	public Client getClient(Long id) {
		Client client = null;
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM CLIENT WHERE ID_CLIENT=?");

			ps.setLong(1, id);
			ResultSet resultat = ps.executeQuery();
			if (resultat.next()) {
				client = new Client();
				
				 client.setId(resultat.getLong("ID_CLIENT"));
				 client.setCivilite(resultat.getString("CIVILITE"));
				 client.setNom(resultat.getString("NOM"));
				 client.setPrenom(resultat.getString("PRENOM"));
				 client.setDateNaissance(resultat.getString("DATE_NAISSANCE"));
				 client.setLieuNaissance(resultat.getString("LIEU_NAISSANCE"));
				 client.setSexe(resultat.getString("SEXE"));
				 client.setType(resultat.getString("TYPE_CLIENT"));
				 client.setPieceIdentite(resultat.getString("TYPE_PIECE_IDENTITE"));
				 client.setRefPieceIdentite(resultat.getString("REF_PIECE_IDENTITE"));
				 client.setAdresse(resultat.getString("ADRESSE"));
				 client.setTelephone(resultat.getString("TELEPHONE"));
				 client.setEmail(resultat.getString("EMAIL")); 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public Client consulterClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client modifierClient(Client client) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					"UPDATE CLIENT SET CIVILITE=?,NOM=?, PRENOM=?, DATE_NAISSANCE=?,LIEU_NAISSANCE=?, "
					+ "SEXE=?, TYPE_CLIENT=?, TYPE_PIECE_IDENTITE=?, REF_PIECE_IDENTITE=?,"
					+ "ADRESSE=?, TELEPHONE=?, EMAIL=? WHERE ID_CLIENT=?");
			
			 ps.setString(1, client.getCivilite());
			 ps.setString(2, client.getNom());
			 ps.setString(3, client.getPrenom());
			 ps.setString(4, client.getDateNaissance()); 
			 ps.setString(5, client.getLieuNaissance()); 
			 ps.setString(6, client.getSexe()); 
			 ps.setString(7, client.getType()); 
			 ps.setString(8, client.getPieceIdentite()); 
			 ps.setString(9, client.getRefPieceIdentite());
			 ps.setString(10, client.getAdresse()); 
			 ps.setString(11, client.getTelephone()); 
			 ps.setString(12, client.getEmail()); 
			 ps.setLong(13, client.getId());
			 ps.executeUpdate();
			 
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public void supprimerClient(Long id) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("DELETE FROM CLIENT WHERE ID_CLIENT=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
