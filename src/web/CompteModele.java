package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Compte;

public class CompteModele {
	
	private String motCle;
	private List<Compte> listeCompteRecherche = new ArrayList<Compte>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Compte> getListeCompteRecherche() {
		return listeCompteRecherche;
	}
	public void setListeCompteRecherche(List<Compte> listeCompteRecherche) {
		this.listeCompteRecherche = listeCompteRecherche;
	}
	
	

}
