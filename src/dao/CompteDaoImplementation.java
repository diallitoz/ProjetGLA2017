package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Compte;

public class CompteDaoImplementation implements ICompteDao {

	@Override
	public Compte enregistrerCompte(Compte cpte) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement(
					"INSERT INTO COMPTE (TYPE,DATE_CREATION,ID_CLIENT, ID_GESTIONNAIRE, SOLDE) VALUES (?,?,?,?,?)");
			ps.setString(1, cpte.getType());
			ps.setString(2, cpte.getDateCreation());
			ps.setLong(3, cpte.getIdClient());
			ps.setLong(4, cpte.getIdGestionnaire());
			ps.setDouble(5, cpte.getSolde());
			ps.executeUpdate();
			PreparedStatement ps2 = connexion.prepareStatement("SELECT MAX(ID_COMPTE) AS MAX_ID FROM COMPTE");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				cpte.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpte;
	}

	@Override
	public List<Compte> rechercherCompte(String motCle) {
		List<Compte> listCompte = new ArrayList<Compte>();
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM COMPTE WHERE TYPE LIKE ?");

			ps.setString(1, motCle);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Compte cpte = new Compte();
				cpte.setId(resultat.getLong("ID_COMPTE"));
				cpte.setType(resultat.getString("TYPE"));
				cpte.setDateCreation(resultat.getString("DATE_CREATION"));
				cpte.setIdClient(resultat.getLong("ID_CLIENT"));
				cpte.setIdGestionnaire(resultat.getLong("ID_GESTIONNAIRE"));
				cpte.setSolde(resultat.getDouble("SOLDE"));
				listCompte.add(cpte);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCompte;
	}

	@Override
	public Compte getCompte(Long id) {
		Compte cpte = null;
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM COMPTE WHERE ID_COMPTE=?");

			ps.setLong(1, id);
			ResultSet resultat = ps.executeQuery();
			if (resultat.next()) {
				cpte = new Compte();
				cpte.setId(resultat.getLong("ID_COMPTE"));
				cpte.setType(resultat.getString("TYPE"));
				cpte.setDateCreation(resultat.getString("DATE_CREATION"));
				cpte.setIdClient(resultat.getLong("ID_CLIENT"));
				cpte.setIdGestionnaire(resultat.getLong("ID_GESTIONNAIRE"));
				cpte.setSolde(resultat.getDouble("SOLDE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpte;
	}

	@Override
	public Compte consulterCompte(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte modifierCompte(Compte cpte) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("UPDATE COMPTE SET TYPE=?,DATE_CREATION=?,ID_CLIENT=?, ID_GESTIONNAIRE=?, SOLDE=? WHERE ID_COMPTE=?");
			ps.setString(1, cpte.getType());
			ps.setString(2, cpte.getDateCreation());
			ps.setLong(3, cpte.getIdClient());
			ps.setLong(4, cpte.getIdGestionnaire());
			ps.setDouble(5, cpte.getSolde());
			ps.setLong(6, cpte.getId());
			ps.executeUpdate();
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpte;
	}

	@Override
	public void supprimerCompte(Long id) {
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("DELETE FROM COMPTE WHERE ID_COMPTE=?");
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
	public void debiterCompte(Long id) {
		// TODO Auto-generated method stub

	}

}
