package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
 
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bilan
 *
 */
@Entity
@Table(name = "bilan")
public class Bilan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int Id;
	private Date date;
	private String Description;
	@OneToOne(mappedBy = "bilan", cascade = CascadeType.ALL)
	private ImmobilisationFixe immobFixe;
	
	@OneToOne(cascade = CascadeType.REMOVE , mappedBy = "bilan")
	private PassifNonCourant passifNonCourant;
	public PassifCourant getPassifCourant() {
		return passifCourant;
	}

	public void setPassifCourant(PassifCourant passifCourant) {
		this.passifCourant = passifCourant;
	}

	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "bilan")
	private PassifCourant passifCourant;
	
	
	
	
	
	
	

	public PassifNonCourant getPassifNonCourant() {
		return passifNonCourant;
	}

	public void setPassifNonCourant(PassifNonCourant passifNonCourant) {
		this.passifNonCourant = passifNonCourant;
	}

	public ImmobilisationFixe getImmobFixe() {
		return immobFixe;
	}

	public void setImmobFixe(ImmobilisationFixe immobFixe) {
		this.immobFixe = immobFixe;
	}

	public Bilan() {
		this.date = new Date();
	}

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

}
