package dao;

import java.util.List;

import metier.entities.Payement;

public interface IPayementDao {
	
	
	public List<Payement> rechercherPayement(Long idCompte,String motCle);
	
	public List<Payement> rechercherPayementPresta(Long idCompte,String motCle);
	public Payement consulterPayement(Long id);
		
	public Payement getPayement(Long id);
	
}
