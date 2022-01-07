package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ClientBq {

	@Id
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "nom_banque")
	private Banque banque;

	@ManyToMany
	@JoinTable(name = "Client_Compte", joinColumns = @JoinColumn(name = "Nom_Client", referencedColumnName = "nom"), inverseJoinColumns = @JoinColumn(name = "Numero_Compte", referencedColumnName = "numero"))
	private Set<Compte> comptes;

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
