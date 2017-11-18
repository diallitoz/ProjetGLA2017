package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;

public class ClientDaoImplementation implements IClientDao {
	
	public void setClient(){
		
	}

	@Override
	public Client enregistrerClient(Client client) {
		final Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement prepaStat = connexion.prepareStatement(
					"INSERT INTO CLIENT (CIVILITE,NOM,PRENOM,DATE_NAISSANCE,LIEU_NAISSANCE,SEXE,TYPE_CLIENT,"
							+ "TYPE_PIECE_IDENTITE,REF_PIECE_IDENTITE,ADRESSE,TELEPHONE,EMAIL) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			prepaStat.setString(1, client.getCivilite());
			prepaStat.setString(2, client.getNom());
			prepaStat.setString(3, client.getPrenom());
			prepaStat.setString(4, client.getDateNaissance());
			prepaStat.setString(5, client.getLieuNaissance());
			prepaStat.setString(6, client.getSexe());
			prepaStat.setString(7, client.getType());
			prepaStat.setString(8, client.getPieceIdentite());
			prepaStat.setString(9, client.getRefPieceIdentite());
			prepaStat.setString(10, client.getAdresse());
			prepaStat.setString(11, client.getTelephone());
			prepaStat.setString(12, client.getEmail());
	
			prepaStat.executeUpdate();
			PreparedStatement ps2 = connexion.prepareStatement("SELECT MAX(ID_CLIENT) AS MAX_ID FROM CLIENT");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				client.setId(rs.getLong("MAX_ID"));
			}
			prepaStat.close();
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
