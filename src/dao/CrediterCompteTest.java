package dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import metier.entities.Compte;

public class CrediterCompteTest {

	@Test
	public void testCreationCompte() {
		CompteDaoImplementation dao = new CompteDaoImplementation();
		Compte cpte1 = dao.enregistrerCompte(new Compte("Prestataire", "2017.11.07", 3, 2, 50000.0));
		cpte1 = dao.crediterCompte(cpte1.getId(), 1000000.0, new Date());
	}
}
