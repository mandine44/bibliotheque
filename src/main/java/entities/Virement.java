package entities;

import javax.persistence.Entity;

@Entity
public class Virement {

	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
