package metier.entities;

import java.io.Serializable;
//import java.sql.Date;

public class Client implements Serializable {

	private Long id;
	private String civilite = "";
	private String nom = "";
	private String prenom = "";
	private String dateNaissance = "";
	private String lieuNaissance = "";
	private String sexe = "";

	private String type = "";
	private String pieceIdentite = "";
	private String refPieceIdentite = "";
	private String adresse = "";
	private String telephone = "";
	private String email = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPieceIdentite() {
		return pieceIdentite;
	}

	public void setPieceIdentite(String pieceIndentite) {
		this.pieceIdentite = pieceIndentite;
	}

	public String getRefPieceIdentite() {
		return refPieceIdentite;
	}

	public void setRefPieceIdentite(String refPieceIdentite) {
		this.refPieceIdentite = refPieceIdentite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Client(String civilite, String nom, String prenom, String dateNaissance, String lieuNaissance, String sexe,
			String type, String pieceIdentite, String refPieceIdentite, String adresse, String telephone,
			String email) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.type = type;
		this.pieceIdentite = pieceIdentite;
		this.refPieceIdentite = refPieceIdentite;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + ", sexe=" + sexe + ", type="
				+ type + ", pieceIdentite=" + pieceIdentite + ", refPieceIdentite=" + refPieceIdentite + ", adresse="
				+ adresse + ", telephone=" + telephone + ", email=" + email + "]";
	}

}
