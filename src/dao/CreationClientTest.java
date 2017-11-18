package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.entities.Client;

public class CreationClientTest {

	@Test
	public void testCreationCompte() {
		ClientDaoImplementation dao1 = new ClientDaoImplementation();
		Client client1 = dao1.enregistrerClient(new Client("M", "DIALLO","Azise", "1988.09.11", "Bobo", "M", "Etudiant","Passport","A111 du 11 Sep 2015","ky tuc xa My dinh","01665853416","diallo.p21@ifi.edu.vn"));
		assertEquals("DIALLO", client1.getNom());
	}
}
