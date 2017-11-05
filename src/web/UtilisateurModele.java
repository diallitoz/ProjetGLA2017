package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Utilisateur;

public class UtilisateurModele {
	private String motCle;
	private List<Utilisateur> listeUtilisateurRecherche = new ArrayList<Utilisateur>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Utilisateur> getListeUtilisateurRecherche() {
		return listeUtilisateurRecherche;
	}
	public void setListeUtilisateurRecherche(List<Utilisateur> listeUtilisateurRecherche) {
		this.listeUtilisateurRecherche = listeUtilisateurRecherche;
	}
	
	

}
