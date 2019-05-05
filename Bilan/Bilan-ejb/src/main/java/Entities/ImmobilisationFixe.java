package Entities;

import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ImmobilisationFixe
 *
 */
@Entity
@Table(name="ImmobilisationFixe")

public class ImmobilisationFixe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int Id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
	private   ImmobilisationNonCorporelle  ImmobNonCorporelles;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
	private   ImmobilisationCorporelle  ImmobCorporelles;
	@OneToOne(cascade=CascadeType.PERSIST)
	@MapsId
	private Bilan bilan;
	
	public Bilan getBilan() {
		return bilan;
	}

	public void setBilan(Bilan bilan) {
		this.bilan = bilan;
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

	public   ImmobilisationNonCorporelle  getImmobNonCorporelles() {
		return ImmobNonCorporelles;
	}

	public void setImmobNonCorporelles(  ImmobilisationNonCorporelle  immobNonCorporelles) {
		ImmobNonCorporelles = immobNonCorporelles;
	}

	public   ImmobilisationCorporelle  getImmobCorporelles() {
		return ImmobCorporelles;
	}

	public void setImmobCorporelles(  ImmobilisationCorporelle  immobCorporelles) {
		ImmobCorporelles = immobCorporelles;
	}


	public ImmobilisationFixe() {
		super();
	}

}
