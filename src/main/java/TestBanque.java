import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Adresse;
import entities.Banque;
import entities.ClientBq;

public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;

		// initialisation de l'entity manager
		emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// ajout d'un Client avec une Adresse et de sa banque

		Adresse uneAdresse = new Adresse();
		uneAdresse.setNumero(6);
		uneAdresse.setRue("allée du Moulin Quilly");
		uneAdresse.setCodePostal(44220);
		uneAdresse.setVille("Coueron");

		/*
		 * Adresse AutreAdresse = new Adresse(); AutreAdresse.setNumero(16);
		 * AutreAdresse.setRue("rue Pasteur"); AutreAdresse.setCodePostal(44210);
		 * AutreAdresse.setVille("Pornic");
		 */

		Banque uneBanque = new Banque();
		uneBanque.setNom("Credit Agricolee");

		ClientBq unClient = new ClientBq();
		unClient.setNom("Hurett");
		unClient.setPrenom("Amandine");
		unClient.setAdresse(uneAdresse);
		unClient.setDateNaissance(LocalDate.of(1980, 1, 20));
		unClient.setBanque(uneBanque);

		/*
		 * ClientBq autreClient = new ClientBq(); unClient.setNom("Dumazeau");
		 * unClient.setPrenom("Lulu"); unClient.setAdresse(AutreAdresse);
		 * unClient.setDateNaissance(LocalDate.of(2015, 7, 23));
		 */

		Set<ClientBq> setClients = new HashSet<ClientBq>();
		setClients.add(unClient);
		// setClients.add(autreClient);

		// uneBanque.setClients(setClients);

		// em.persist(uneAdresse);
		// em.persist(AutreAdresse);
		em.persist(unClient);
		// em.persist(autreClient);
		em.persist(uneBanque);

		tx.commit();
		em.close();
		emf.close();

	}

}
