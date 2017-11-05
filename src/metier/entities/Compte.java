package metier.entities;

import java.io.Serializable;
//import java.sql.Date;


public class Compte implements Serializable {
	
	private Long id;
	private String type = "";
	private String dateCreation;
	private long idClient;
	private long idGestionnaire;
	private Double solde;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String type, String dateCreation, long idClient, long idGestionnaire, Double solde) {
		super();
		this.type = type;
		this.dateCreation = dateCreation;
		this.idClient = idClient;
		this.idGestionnaire = idGestionnaire;
		this.solde = solde;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Long getIdGestionnaire() {
		return idGestionnaire;
	}
	public void setIdGestionnaire(Long idGestionnaire) {
		this.idGestionnaire = idGestionnaire;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", type=" + type + ", dateCreation=" + dateCreation + ", idClient=" + idClient
				+ ", idGestionnaire=" + idGestionnaire + ", solde=" + solde + "]";
	}
	
	
	
	
	
	
	

}
