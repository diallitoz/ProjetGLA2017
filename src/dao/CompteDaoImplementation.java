package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import metier.entities.Compte;
import metier.entities.Operations;
import metier.entities.Payement;

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
		Compte compte = new Compte();
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM COMPTE WHERE ID_COMPTE LIKE ?");

			ps.setLong(1, id);
			ResultSet resultat = ps.executeQuery();
			if (resultat.next()) {
				compte.setId(resultat.getLong("ID_COMPTE"));
				compte.setType(resultat.getString("TYPE"));
				compte.setDateCreation(resultat.getString("DATE_CREATION"));
				compte.setIdClient(resultat.getLong("ID_CLIENT"));
				compte.setIdGestionnaire(resultat.getLong("ID_GESTIONNAIRE"));
				compte.setSolde(resultat.getDouble("SOLDE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compte;
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
	public Compte debiterCompte(Long id, double montant, Date date) {
		
		Compte cpte = getCompte(id);
		date = new Date();
		cpte.setSolde(cpte.getSolde() + montant);
		
		String date1 = date.toString();
		
		Operations operation = new Operations(date1,montant,cpte.getId());
		
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("UPDATE COMPTE SET SOLDE=? WHERE ID_COMPTE=?");
			ps.setDouble(1, cpte.getSolde());
			ps.setLong(2, cpte.getId());
			ps.executeUpdate();
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement ps2 = connexion.prepareStatement("INSERT INTO OPERATIONS (DATE_OPERATION,MONTANT, ID_COMPTE) VALUES (?,?,?)");
			ps2.setString(1, operation.getDateOperation());
			ps2.setDouble(2, operation.getMontant());
			ps2.setLong(3, operation.getIdCompte());
			ps2.executeUpdate();
			PreparedStatement ps3 = connexion.prepareStatement("SELECT MAX(ID_OPERATIONS) AS MAX_ID FROM OPERATIONS");
			ResultSet rs = ps3.executeQuery();
			if (rs.next()) {
				operation.setId(rs.getLong("MAX_ID"));
			}
			ps2.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cpte;

	}
	
	
	@Override
	public Payement EffectuerPayement(Long idPayeur,Long idBeneficiaire, double montant, String datePayement, String typePayement) {
		
		Compte cptePayeur = getCompte(idPayeur);
		Compte cpteBeneficiaire = getCompte(idBeneficiaire);
		datePayement = new Date().toString();
		Payement payement = new Payement();
		
		//if(cptePayeur.getSolde() >= montant + 100000.0){
			cptePayeur.setSolde(cptePayeur.getSolde() - montant);
			cpteBeneficiaire.setSolde(cpteBeneficiaire.getSolde() + montant);
			
			payement.setDatePayement(datePayement);
			payement.setMontant(montant);
			payement.setIdComptePayeur(idPayeur);
			payement.setIdCompteBeneficiaire(idBeneficiaire);
			payement.setType(typePayement);
		//}
		
		
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("UPDATE COMPTE SET SOLDE=? WHERE ID_COMPTE=?");
			ps.setDouble(1, cptePayeur.getSolde());
			ps.setLong(2, cptePayeur.getId());
			ps.executeUpdate();
			ps.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			PreparedStatement ps2 = connexion.prepareStatement("UPDATE COMPTE SET SOLDE=? WHERE ID_COMPTE=?");
			ps2.setDouble(1, cpteBeneficiaire.getSolde());
			ps2.setLong(2, cpteBeneficiaire.getId());
			ps2.executeUpdate();
			ps2.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			PreparedStatement ps3 = connexion.prepareStatement("INSERT INTO PAYEMENT (DATE_PAYEMENT,ID_CPTE_PAYEUR, ID_CPTE_BENEF,MONTANT,TYPE_PAYEMENT) VALUES (?,?,?,?,?)");
			ps3.setString(1, payement.getDatePayement());
			ps3.setLong(2, payement.getIdComptePayeur());
			ps3.setLong(3, payement.getIdCompteBeneficiaire());
			ps3.setDouble(4, payement.getMontant());
			ps3.setString(5, payement.getType());
			ps3.executeUpdate();
			PreparedStatement ps4 = connexion.prepareStatement("SELECT MAX(ID_PAYEMENT) AS MAX_ID FROM PAYEMENT");
			ResultSet rs = ps4.executeQuery();
			if (rs.next()) {
				payement.setId(rs.getLong("MAX_ID"));
			}
			ps3.close();
			// connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return payement;

	}

}
