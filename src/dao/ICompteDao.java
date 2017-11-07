package dao;

import java.util.Date;
import java.util.List;

import metier.entities.Compte;
import metier.entities.Payement;

public interface ICompteDao {
	
	public Compte enregistrerCompte(Compte cpte);
	public List<Compte> rechercherCompte(String motCle);
	public Compte consulterCompte(Long id);
	public Compte modifierCompte(Compte cpte);
	public void supprimerCompte(Long id);
	public Compte debiterCompte(Long id,double montant,Date date);
	public Compte getCompte(Long id);
	public Payement EffectuerPayement(Long idPayeur, Long idBeneficiaire, double montant, String datePayement,
			String typePayement);
}
