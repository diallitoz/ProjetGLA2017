package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;

public class ClientModele {
	
	private String motCle;
	private List<Client> listeClientRecherche = new ArrayList<Client>();
	
	public String getMotCle() {
		return motCle;
	}
	
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	
	public List<Client> getListeClientRecherche() {
		return listeClientRecherche;
	}
	
	public void setListeClientRecherche(List<Client> listeClientRecherche) {
		this.listeClientRecherche = listeClientRecherche;
	}
	
	

}
