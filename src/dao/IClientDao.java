package dao;

import java.util.List;

import metier.entities.Client;


public interface IClientDao {
	
	public Client enregistrerClient(Client client);
	public List<Client> rechercherClient(String motCle);
	public Client consulterClient(Long id);
	public Client modifierClient(Client client);
	public void supprimerClient(Long id);
	public Client getClient(Long id);
}
