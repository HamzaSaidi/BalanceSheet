package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import Entities.Bilan;
import Entities.PassifNonCourant;

import Interfaces.IpassifNonCourant;

@Stateless
public class PassifNonCourantEJB implements IpassifNonCourant {
	@PersistenceContext
	EntityManager em;
	BilanEJB bilanEJb = new BilanEJB();

	@Override
	public void AddPassifNoncourant(PassifNonCourant passifnncourant) {
		// TODO Auto-generated method stub
		Bilan bilanCurrent = bilanEJb.FindCurrentBilan();
		if (bilanCurrent == null) {
			bilanCurrent = new Bilan();
		}
		passifnncourant.setBilan(bilanCurrent);
		em.persist(passifnncourant);

	}

	@Override
	public void RemovePassifNoncourant(PassifNonCourant passifnncourant) {
		// TODO Auto-generated method stub
		em.remove(passifnncourant);

	}

	@Override
	public void UpdatePassifNoncourant(PassifNonCourant passifnncourant) {
		em.persist(passifnncourant);
	}

	@Override
	public PassifNonCourant FindCurrentPassifNoncourant() {
		TypedQuery<PassifNonCourant> query = em.createQuery(
				"SELECT  PassifNonCourant passif WHERE EXTRACT(YEAR,passif.date)= EXTRACT(YEAR,CURRENT_DATE)",
				PassifNonCourant.class);

		return query.getSingleResult();
	}

	@Override
	public List<PassifNonCourant> FindPassifNoncourantBYDateIntervalle(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		TypedQuery<PassifNonCourant> query = em.createQuery(
				"select PassifNonCourant passif WHERE passif.date" + " Between:startDate AND :endDate",
				PassifNonCourant.class);
		query.setParameter("startDate", startDate, TemporalType.DATE);
		query.setParameter("endDate", endDate, TemporalType.DATE);

		return query.getResultList();

	}

	@Override
	public Double CalculTotalePassifNonCourant(PassifNonCourant passifnncourant) {
		// TODO Auto-generated method stub
		Double totale = passifnncourant.getCapitalSocial() + passifnncourant.getDetteBancaire()
				+ passifnncourant.getResultatDexercice();
		return totale;
	}

}
