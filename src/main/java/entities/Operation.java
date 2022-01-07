package entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation {

	@Id
	private int id;
	private LocalDateTime date;
	private double montant;
	private String motif;

	@ManyToOne
	@JoinColumn(name = "NumCompte")
	private Compte unCompte;

	public Compte getUnCompte() {
		return unCompte;
	}

	public void setUnCompte(Compte unCompte) {
		this.unCompte = unCompte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

}
