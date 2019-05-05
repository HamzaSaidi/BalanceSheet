package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ImmobilisationNonCorporelle
 *
 */
@Entity
@Table(name = "ImmobilisationNonCorporelle")
public class ImmobilisationNonCorporelle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String description;
	private double montant;
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "immobNonCrpl")
	private List<Investement> investements;

	public List<Investement> getInvestements() {
		return investements;
	}

	public void setInvestements(List<Investement> investements) {
		this.investements = investements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public ImmobilisationNonCorporelle() {
		this.date = new Date();
	}

}
