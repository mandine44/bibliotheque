package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque {

	@Id
	private String nom;

	@OneToMany(mappedBy = "banque")
	private Set<ClientBq> clients;

	public Set<ClientBq> getClients() {
		return clients;
	}

	public void setClients(Set<ClientBq> clients) {
		this.clients = clients;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
