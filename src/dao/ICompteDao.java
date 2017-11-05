package dao;

import java.util.List;

import metier.entities.Compte;

public interface ICompteDao {
	
	public Compte enregistrerCompte(Compte cpte);
	public List<Compte> rechercherCompte(String motCle);
	public Compte consulterCompte(Long id);
	public Compte modifierCompte(Compte cpte);
	public void supprimerCompte(Long id);
	public void debiterCompte(Long id);
	public Compte getCompte(Long id);
}