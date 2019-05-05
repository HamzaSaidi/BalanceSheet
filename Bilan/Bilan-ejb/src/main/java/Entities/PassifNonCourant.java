package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PassifNonCourant
 *
 */
@Entity

public class PassifNonCourant implements Serializable {

	@Id
	private int Id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private double CapitalSocial;
	private double DetteBancaire;
	@Column(nullable=true)
	private double ResultatDexercice;
	@OneToOne
	@MapsId
	private Bilan bilan;

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

	
	private static final long serialVersionUID = 1L;

	public PassifNonCourant() {
		this.date=new Date();
	}

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public double getCapitalSocial() {
		return this.CapitalSocial;
	}

	public void setCapitalSocial(double CapitalSocial) {
		this.CapitalSocial = CapitalSocial;
	}

	public double getDetteBancaire() {
		return this.DetteBancaire;
	}

	public void setDetteBancaire(double DetteBancaire) {
		this.DetteBancaire = DetteBancaire;
	}

	public double getResultatDexercice() {
		return this.ResultatDexercice;
	}

	public void setResultatDexercice(double ResultatDexercice) {
		this.ResultatDexercice = ResultatDexercice;
	}

}
