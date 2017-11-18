package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import metier.entities.Payement;

public class PayementDaoImplementation implements IPayementDao {

	

	@Override
	public List<Payement> rechercherPayement(Long iDCompte, String motCle) {
		List<Payement> listPayement = new ArrayList<Payement>();
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM PAYEMENT WHERE ((DATE_PAYEMENT LIKE LOWER('%"+motCle+"%') OR TYPE_PAYEMENT LIKE LOWER('%"+motCle+"%')) AND ID_CPTE_PAYEUR LIKE ?)");

			ps.setLong(1, iDCompte);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Payement payement = new Payement();
				payement.setId(resultat.getLong("ID_PAYEMENT"));
				payement.setType(resultat.getString("TYPE_PAYEMENT"));
				payement.setDatePayement(resultat.getString("DATE_PAYEMENT"));
				payement.setIdComptePayeur(resultat.getLong("ID_CPTE_PAYEUR"));
				payement.setIdCompteBeneficiaire(resultat.getLong("ID_CPTE_BENEF"));
				payement.setMontant(resultat.getDouble("MONTANT"));
				listPayement.add(payement);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPayement;
	}
	

	@Override
	public List<Payement> rechercherPayementPresta(Long iDCompte, String motCle) {
		List<Payement> listPayement = new ArrayList<Payement>();
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM PAYEMENT WHERE ((DATE_PAYEMENT LIKE LOWER('%"+motCle+"%') OR TYPE_PAYEMENT LIKE LOWER('%"+motCle+"%')) AND ID_CPTE_BENEF LIKE ?)");

			ps.setLong(1, iDCompte);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Payement payement = new Payement();
				payement.setId(resultat.getLong("ID_PAYEMENT"));
				payement.setType(resultat.getString("TYPE_PAYEMENT"));
				payement.setDatePayement(resultat.getString("DATE_PAYEMENT"));
				payement.setIdComptePayeur(resultat.getLong("ID_CPTE_PAYEUR"));
				payement.setIdCompteBeneficiaire(resultat.getLong("ID_CPTE_BENEF"));
				payement.setMontant(resultat.getDouble("MONTANT"));
				listPayement.add(payement);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPayement;
	}

	@Override
	public Payement getPayement(Long id) {
		Payement payement = null;
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM PAYEMENT WHERE ID_PAYEMENT=?");

			ps.setLong(1, id);
			ResultSet resultat = ps.executeQuery();
			if (resultat.next()) {
				payement = new Payement();
				payement.setId(resultat.getLong("ID_PAYEMENT"));
				payement.setType(resultat.getString("TYPE_PAYEMENT"));
				payement.setDatePayement(resultat.getString("DATE_PAYEMENT"));
				payement.setIdComptePayeur(resultat.getLong("ID_CPTE_PAYEUR"));
				payement.setIdCompteBeneficiaire(resultat.getLong("ID_CPTE_BENEF"));
				payement.setMontant(resultat.getDouble("MONTANT"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payement;
	}
	
	
	@Override
	public Payement consulterPayement(Long id) {
		Payement payement = new Payement();
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM PAYEMENT WHERE ID_PAYEMENT LIKE ?");

			ps.setLong(1, id);
			ResultSet resultat = ps.executeQuery();
			if (resultat.next()) {
				payement.setId(resultat.getLong("ID_PAYEMENT"));
				payement.setType(resultat.getString("TYPE_PAYEMENT"));
				payement.setDatePayement(resultat.getString("DATE_CREATION"));
				payement.setIdComptePayeur(resultat.getLong("ID_CPTE_PAYEUR"));
				payement.setIdCompteBeneficiaire(resultat.getLong("ID_CPTE_BENEF"));
				payement.setMontant(resultat.getDouble("MONTANT"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payement;
	}

}
