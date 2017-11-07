package metier.entities;

import java.io.Serializable;

public class Payement implements Serializable{
	
	private Long id;
	private String datePayement;
	private double montant;
	private long idComptePayeur;
	private long idCompteBeneficiaire;
	private String type="";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatePayement() {
		return datePayement;
	}
	public void setDatePayement(String datePayement) {
		this.datePayement = datePayement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public long getIdComptePayeur() {
		return idComptePayeur;
	}
	public void setIdComptePayeur(long idComptePayeur) {
		this.idComptePayeur = idComptePayeur;
	}
	public long getIdCompteBeneficiaire() {
		return idCompteBeneficiaire;
	}
	public void setIdCompteBeneficiaire(long idCompteBeneficiaire) {
		this.idCompteBeneficiaire = idCompteBeneficiaire;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Payement(String datePayement, double montant, long idComptePayeur, long idCompteBeneficiaire, String type) {
		super();
		this.datePayement = datePayement;
		this.montant = montant;
		this.idComptePayeur = idComptePayeur;
		this.idCompteBeneficiaire = idCompteBeneficiaire;
		this.type = type;
	}
	public Payement() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payement [id=" + id + ", datePayement=" + datePayement + ", montant=" + montant + ", idComptePayeur="
				+ idComptePayeur + ", idCompteBeneficiaire=" + idCompteBeneficiaire + ", type=" + type + "]";
	}
	
	
	

}
