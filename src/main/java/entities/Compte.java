package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

	@Id
	private String numero;
	private double solde;

	@OneToMany(mappedBy = "unCompte")
	private Set<Operation> setOperations;

	@ManyToMany(mappedBy = "comptes")
	private Set<ClientBq> clients;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Operation> getSetOperations() {
		return setOperations;
	}

	public void setSetOperations(Set<Operation> setOperations) {
		this.setOperations = setOperations;
	}

	public Set<ClientBq> getClients() {
		return clients;
	}

	public void setClients(Set<ClientBq> clients) {
		this.clients = clients;
	}

}
