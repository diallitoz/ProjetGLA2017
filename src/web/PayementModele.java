package web;

import java.util.ArrayList;
import java.util.List;


import metier.entities.Payement;

public class PayementModele {
	
	private String motCle;
	private Long idPayement;
	private Long idCompte;
	
	
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	private List<Payement> listePayementRecherche = new ArrayList<Payement>();
	private Payement payement = new Payement();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public Long getIdPayement() {
		return idPayement;
	}
	public void setIdPayement(Long idPayement) {
		this.idPayement = idPayement;
	}
	public List<Payement> getListePayementRecherche() {
		return listePayementRecherche;
	}
	public void setListePayementRecherche(List<Payement> listePayementRecherche) {
		this.listePayementRecherche = listePayementRecherche;
	}
	public Payement getPayement() {
		return payement;
	}
	public void setPayement(Payement payement) {
		this.payement = payement;
	}
	
	

}
