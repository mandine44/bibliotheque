import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Emprunt;
import entities.Livre;

public class TestBibliotheque {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;

		// initialisation de l'entity manager
		emf = Persistence.createEntityManagerFactory("emprunt_bibliotheque");
		EntityManager em = emf.createEntityManager();

		// Extraction d'un emprunt et livres associés
		Emprunt emp = em.find(Emprunt.class, 4);

		Set<Livre> setlivres = emp.getLivres();

		if (emp != null) {
			System.out.println("Emprunt 4: ");

			for (Livre l : setlivres) {
				System.out.println(l.getTitre());

			}

		}

		// Extraction de tous les emprunts d'un client donné
		TypedQuery<Emprunt> aQuery = em.createQuery("SELECT e FROM Emprunt e WHERE ID_CLIENT = 3", Emprunt.class);
		List<Emprunt> listeEmprunts = aQuery.getResultList();
		for (Emprunt e : listeEmprunts) {
			System.out.println(e.getId());

		}

	}
}
