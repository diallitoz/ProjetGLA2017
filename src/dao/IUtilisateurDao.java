package dao;

import java.util.List;

import metier.entities.Utilisateur;


public interface IUtilisateurDao {
	
	public Utilisateur enregistrerUtilisateur(Utilisateur user);
	public List<Utilisateur> rechercherUtilisateur(String motCle);
	public Utilisateur consulterUtilisateur(Long id);
	public Utilisateur modifierUtilisateur(Utilisateur user);
	public void supprimerUtilisateur(Long id);
	public void envoyerMotDePasse(String email, String motDePasse);
	public Utilisateur getUtilisateur(Long id);
}
