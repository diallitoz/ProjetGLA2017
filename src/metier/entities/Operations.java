package metier.entities;

import java.io.Serializable;
import java.util.Date;


public class Operations implements Serializable {
	
	private Long id;
	private String dateOperation;
	private double montant;
	private long idCompte;
	
	
	public Operations() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Operations(String dateOperation, double montant, long idCompte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.idCompte = idCompte;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDateOperation() {
		return dateOperation;
	}



	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}



	public Long getIdCompte() {
		return idCompte;
	}



	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	


}
