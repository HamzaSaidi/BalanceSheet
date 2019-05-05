package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import Entities.Investement;
import Entities.ImmobilisationCorporelle;
import Interfaces.IimmobilisationCorporelle;

@Stateless

public class ImmobilisationCorporelleEJB implements IimmobilisationCorporelle {
	@PersistenceContext
	EntityManager em;
	private Double totale;

	@Override
	public Double CalculTotalImmobilisationCorporelle(ImmobilisationCorporelle ImmobCrprl) {
		totale = null;
		for (Investement investement :ImmobCrprl.getInvestements()) {
			totale+=investement.getMontant();
			
		}
		return totale;

	}

	@Override
	public void AddImmobilsationCorporelle(ImmobilisationCorporelle immobCrprl) {
		// TODO Auto-generated method stub
		em.persist(immobCrprl);

	}

	@Override
	public List<ImmobilisationCorporelle> FindByDateIntervalle(Date startdate, Date endDate) {
		TypedQuery<ImmobilisationCorporelle> query = em.createQuery(
				"select ImmobilisationCorporelle immob WHERE immob.date" + " Between:startdate AND :endDate",
				ImmobilisationCorporelle.class);
		query.setParameter("startDate", startdate, TemporalType.DATE);
		query.setParameter("endDate", endDate, TemporalType.DATE);

		return query.getResultList();
	}

	@Override
	public List<ImmobilisationCorporelle> FindByPriceSup(Double prix) {
		TypedQuery<ImmobilisationCorporelle> query = em.createQuery(
				"select ImmobilisationCorporelle immob WHERE immob.montant" + " =>:prix",
				ImmobilisationCorporelle.class);
		query.setParameter("prix", prix);

		return query.getResultList();
	}

	@Override
	public List<ImmobilisationCorporelle> FindByPriceInf(Double prix) {
		TypedQuery<ImmobilisationCorporelle> query = em.createQuery(
				"select ImmobilisationCorporelle immob WHERE immob.montant" + " <=:prix",
				ImmobilisationCorporelle.class);
		query.setParameter("prix", prix);

		return query.getResultList();
	}

	@Override
	public List<ImmobilisationCorporelle> FindCurrentImmoblisationsCorporelles() {
		List<ImmobilisationCorporelle> list = null;
		TypedQuery<ImmobilisationCorporelle> query = em.createQuery(
				"SELECT ImmobilisationCorporelle immob WHERE EXTRACT(YEAR,immob.date)= EXTRACT(YEAR,CURRENT_DATE)",
				ImmobilisationCorporelle.class);
		list = query.getResultList();
		return list;
	}

	@Override
	public ImmobilisationCorporelle FindByDate(Date date) {

		TypedQuery<ImmobilisationCorporelle> query = em.createQuery(
				"SELECT ImmobilisationCorporelle immob WHERE EXTRACT(YEAR,immob.date)= EXTRACT(YEAR,:date)",
				ImmobilisationCorporelle.class);
		query.setParameter("date", date,TemporalType.DATE);
		

		return query.getSingleResult();
	}

}
