package metier.entities;

import java.io.Serializable;

public class Abonnements implements Serializable{
	
	private Long id;
	private String libelle;
	private String type;
	private String dateDebut;
	private String dateFin;
	private double montant;
	private Compte compte;
	
	
	public Abonnements() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Abonnements(String libelle, String type, String dateDebut, String dateFin, double montant, Compte compte) {
		super();
		this.libelle = libelle;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montant = montant;
		this.compte = compte;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	

}
