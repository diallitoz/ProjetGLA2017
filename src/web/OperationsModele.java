package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Compte;

public class OperationsModele {
	
	private String motCle;
	private Long idClient;
	private List<Compte> listeCompteRecherche = new ArrayList<Compte>();
	private Compte compte = new Compte();
	
	
	

	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
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
