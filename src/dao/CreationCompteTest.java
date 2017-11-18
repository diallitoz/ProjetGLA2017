package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.entities.Compte;

public class CreationCompteTest {

	@Test
	public void testCreationCompte() {
		CompteDaoImplementation dao = new CompteDaoImplementation();
		Compte cpte1 = dao.enregistrerCompte(new Compte("Prestataire", "2017.11.07", 3, 2, 50000.0));
		assertEquals("Prestataire", cpte1.getType());
	}
}
