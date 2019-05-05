package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Investement
 *
 */
@Entity

public class Investement implements Serializable {


	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	private int Id;
	@Column(name = "montant", nullable = false)
	private double Montant;
	@Column(name = "type", nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private InvestementType type;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] Facture;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@MapsId
 	private ImmobilisationCorporelle immobCrpl;
	@ManyToOne
	@MapsId
 
	private ImmobilisationNonCorporelle immobNonCrpl;
	public ImmobilisationNonCorporelle getImmobNonCrpl() {
		return immobNonCrpl;
	}

	public void setImmobNonCrpl(ImmobilisationNonCorporelle immobNonCrpl) {
		this.immobNonCrpl = immobNonCrpl;
	}

	public ImmobilisationCorporelle getImmobCrpl() {
		return immobCrpl;
	}

	public void setImmobCrpl(ImmobilisationCorporelle immobCrpl) {
	}

	

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public double getMontant() {
		return this.Montant;
	}

	public void setMontant(double Montant) {
		this.Montant = Montant;
	}


	public InvestementType getType() {
		return type;
	}

	public void setType(InvestementType type) {
		
		this.type = type;
	}

	public byte[] getFacture() {
		return this.Facture;
	}

	public void setFacture(byte[] Facture) {
		this.Facture = Facture;
	}

	public Investement() {
		super();
	}
   
}
