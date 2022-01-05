import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Livre;

public class TestBibli {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;

		// initialisation de l'entity manager
		emf = Persistence.createEntityManagerFactory("emprunt_bibliotheque");
		EntityManager em = emf.createEntityManager();

		// recherche du livre dont l identifiant est 3
		Livre l1 = em.find(Livre.class, 3);
		if (l1 != null) {
			System.out.println("Livre correspondant: " + l1.getTitre() + " de: " + l1.getAuteur());
		}

		// ajout du livre "un sac de billes"

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		/*
		 * Livre l2 = new Livre(); l2.setId(6); l2.setTitre("Un sac de billes");
		 * l2.setAuteur("Joseph Joffo"); em.persist(l2);
		 */

		// modification du titre du livre "1001 recettes de cuisine"
		Livre l3 = em.find(Livre.class, 5);
		if (l3 != null) {
			l3.setTitre("Du plaisir dans la cuisine");
		}

		// Requete JPQL pour extraire un livre en fonction de son titre
		TypedQuery<Livre> query1 = em.createQuery("SELECT l FROM Livre l WHERE titre = 'Germinal'", Livre.class);
		Livre l4 = query1.getResultList().get(0);

		// Requete JPQL pour extraire un livre en fonction de son auteur
		TypedQuery<Livre> query2 = em.createQuery("SELECT l FROM Livre l WHERE auteur = 'Emile Zola'", Livre.class);
		Livre l5 = query2.getResultList().get(0);

		// Supprimer le livre d'identifiant 1
		/*
		 * Livre l6 = em.find(Livre.class, 1); if (l6 != null) { em.remove(l6); }
		 */

		TypedQuery<Livre> query3 = em.createQuery("SELECT l FROM Livre l", Livre.class);
		List<Livre> liste = query3.getResultList();
		for (Livre l : liste) {
			System.out.println("Titre du livre: " + l.getTitre() + " Nom de l'auteur: " + l.getAuteur());
		}

		tx.commit();

		em.close();

		emf.close();

	}

}
