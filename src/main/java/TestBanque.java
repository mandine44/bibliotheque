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
import entities.Compte;
import entities.LivretA;
import entities.Operation;
import entities.Virement;

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

		Banque uneBanque = new Banque();
		uneBanque.setNom("Credit Agricole");

		ClientBq unClient = new ClientBq();
		unClient.setNom("Huret");
		unClient.setPrenom("Amandine");
		unClient.setAdresse(uneAdresse);
		unClient.setDateNaissance(LocalDate.of(1980, 1, 20));
		unClient.setBanque(uneBanque);

		Set<ClientBq> setClients = new HashSet<ClientBq>();
		setClients.add(unClient);

// Ajout d'un compte de type Livret A sur lequel on fait une operation de type virement
		Virement unVirement = new Virement();
		unVirement.setId(15);
		unVirement.setDate(LocalDate.of(2022, 3, 10));
		unVirement.setMontant(200);
		unVirement.setMotif("remboursement resto");
		unVirement.setBeneficiaire("moi");

		Set<Operation> unSetOperations = new HashSet<Operation>();
		unSetOperations.add(unVirement);

		LivretA unLivretA = new LivretA();
		unLivretA.setNumero("8772");
		unLivretA.setSolde(8596);
		unLivretA.setTaux(3);
		unLivretA.setSetOperations(unSetOperations);

		// attention valoriser dans les 2 sens pour liaison bidirectionnelle
		unVirement.setUnCompte(unLivretA);

		Set<Compte> unSetCompte = new HashSet<Compte>();
		unSetCompte.add(unLivretA);

		unClient.setComptes(unSetCompte);

		em.persist(uneBanque);
		em.persist(unClient);
		em.persist(unVirement);
		em.persist(unLivretA);

		tx.commit();
		em.close();
		emf.close();

	}

}
