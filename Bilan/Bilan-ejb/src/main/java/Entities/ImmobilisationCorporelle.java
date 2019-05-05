package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ImmobilisationCorporelle
 *
 */
@Entity
@Table(name = "ImmobilisationCorporelle")

public class ImmobilisationCorporelle implements Serializable {

	@Id
	private int Id;
	private double montant;
	@Temporal(TemporalType.DATE)
	private Date date;

	private String Description;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "immobCrpl")
	private List<Investement> Investements;
	private static final long serialVersionUID = 1L;

	public ImmobilisationCorporelle() {
		this.date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public List<Investement> getInvestements() {
		return Investements;
	}

	public void setInvestements(List<Investement> Investements) {
		this.Investements = Investements;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
