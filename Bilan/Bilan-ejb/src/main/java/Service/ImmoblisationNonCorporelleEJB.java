package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import Entities.ImmobilisationNonCorporelle;
import Entities.Investement;
import Interfaces.IimmobilisationNonCorporelle;

/**
 * Session Bean implementation class ImmoblisationNonCorporelleEJB
 */
@Stateless

public class ImmoblisationNonCorporelleEJB implements IimmobilisationNonCorporelle {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;
	private Double totale;

	@Override
	public void AddImmobilsationCorporelle(ImmobilisationNonCorporelle immobNonCrprl) {
		em.persist(immobNonCrprl);

	}

	@Override
	public Double CalculTotalImmobilisationNonCorporelle(ImmobilisationNonCorporelle immobNonCorporelle) {
		
		for (Investement investement : immobNonCorporelle.getInvestements()) {
			totale+=investement.getMontant();
			
		}
		return totale;

	}

	

	@Override
	public List<ImmobilisationNonCorporelle> FindByPriceSup(Double prix) {
		TypedQuery<ImmobilisationNonCorporelle> query = em.createQuery(
				"select ImmobilisationNonCorporelle immob WHERE immob.montant" + " =>:prix",
				ImmobilisationNonCorporelle.class);
		query.setParameter("prix", prix);

		return query.getResultList();
	}

	@Override
	public List<ImmobilisationNonCorporelle> FindByPriceInf(Double prix) {
		TypedQuery<ImmobilisationNonCorporelle> query = em.createQuery(
				"select ImmobilisationNonCorporelle immob WHERE immob.montant" + " <=:prix",
				ImmobilisationNonCorporelle.class);
		query.setParameter("prix", prix);

		return query.getResultList();
	}

	@Override
	public List<ImmobilisationNonCorporelle> FindCurrentImmoblisationsNonCorporelles() {
		TypedQuery<ImmobilisationNonCorporelle> query = em.createQuery(
				"SELECT ImmobilisationNonCorporelle immob WHERE EXTRACT(YEAR,immob.date)= EXTRACT(YEAR,CURRENT_DATE)",
				ImmobilisationNonCorporelle.class);
		
		return query.getResultList();
	}

	@Override
	public List<ImmobilisationNonCorporelle> FindByDateIntervalle(Date startdate, Date endDate) {
		TypedQuery<ImmobilisationNonCorporelle> query = em.createQuery(
				"select ImmobilisationNonCorporelle immob WHERE immob.date" + " Between:startdate AND :endDate",
				ImmobilisationNonCorporelle.class);
		query.setParameter("startDate", startdate, TemporalType.DATE);
		query.setParameter("endDate", endDate, TemporalType.DATE);

		return query.getResultList();
	}

	@Override
	public ImmobilisationNonCorporelle FindByDate(Date date) {

		TypedQuery<ImmobilisationNonCorporelle> query = em.createQuery(
				"SELECT ImmobilisationNonCorporelle immob WHERE EXTRACT(YEAR,immob.date)= EXTRACT(YEAR,:date)",
				ImmobilisationNonCorporelle.class);
		query.setParameter("date", date,TemporalType.DATE);
		

		return query.getSingleResult();
	

		
	}

}
