package dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import metier.entities.Compte;
import metier.entities.Payement;

public class PayementTest {

	@Test
	public void testPayement() {
		Payement payement = new Payement();
		CompteDaoImplementation dao = new CompteDaoImplementation();
		Compte cpte1 = dao.enregistrerCompte(new Compte("Prestataire", "2017.11.07", 3, 2, 50000.0));
		Compte cpte2 = dao.enregistrerCompte(new Compte("Etudiant", "2017.10.27", 30, 3, 150000.0));
		
		payement = dao.EffectuerPayement(cpte2.getId(), cpte1.getId(), 45000.0, new Date().toString(), "Pressing");
		
		assertEquals("Pressing", payement.getType());
	}

}
