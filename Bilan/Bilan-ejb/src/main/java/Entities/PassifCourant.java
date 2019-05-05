package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PassifCourant
 *
 */
@Entity
@Table
public class PassifCourant implements Serializable {

	@Id
	private int Id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne
	@MapsId
	private Bilan bilan;
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	private double montant;
	private static final long serialVersionUID = 1L;

	public PassifCourant() {
		this.date = new Date();

	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Bilan getBilan() {
		return bilan;
	}

	public void setBilan(Bilan bilan) {
		this.bilan = bilan;
	}

}
