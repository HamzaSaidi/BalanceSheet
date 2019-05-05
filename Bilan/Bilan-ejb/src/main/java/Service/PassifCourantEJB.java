package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import Entities.Bilan;
import Entities.PassifCourant;

import Interfaces.IpassifCourant;

@Stateless
public class PassifCourantEJB implements IpassifCourant {
	@PersistenceContext
	EntityManager em;
	BilanEJB bilanEJb = new BilanEJB();

	@Override
	public void AddPassifCourant(PassifCourant passifcourant) {
		// TODO Auto-generated method stub
		Bilan bilanCurrent = bilanEJb.FindCurrentBilan();
		if (bilanCurrent == null) {
			bilanCurrent = new Bilan();
		}
		passifcourant.setBilan(bilanCurrent);
		em.persist(passifcourant);
	}

	@Override
	public void RemovePassifCourant(PassifCourant passifcourant) {
		// TODO Auto-generated method stub
		em.remove(passifcourant);

	}

	@Override
	public void UpdatePassifCourant(PassifCourant passifcourant) {
		// TODO Auto-generated method stub
		em.persist(passifcourant);

	}

	@Override
	public PassifCourant FindCurrentPassifCourant() {
		// TODO Auto-generated method stub
		TypedQuery<PassifCourant> query = em.createQuery(
				"SELECT  PassifCourant passif WHERE EXTRACT(YEAR,passif.date)= EXTRACT(YEAR,CURRENT_DATE)",
				PassifCourant.class);

		return query.getSingleResult();
	}

	@Override
	public List<PassifCourant> FindPassifCourantBYDateIntervalle(Date startDate, Date endDate) {
		TypedQuery<PassifCourant> query = em.createQuery(
				"select PassifCourant passif WHERE passif.date" + " Between:startDate AND :endDate",
				PassifCourant.class);
		query.setParameter("startDate", startDate, TemporalType.DATE);
		query.setParameter("endDate", endDate, TemporalType.DATE);

		return query.getResultList();
	}

	public Double CalculToTalePassifCourant(PassifCourant passifcourant) {

		return passifcourant.getMontant();
	}
}
