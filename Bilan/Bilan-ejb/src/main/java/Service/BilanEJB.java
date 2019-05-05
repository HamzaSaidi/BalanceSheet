package Service;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import Entities.Bilan;

import Interfaces.IBilanRemote;

@Stateless
public class BilanEJB implements IBilanRemote {
	@PersistenceContext
	EntityManager em;
	ImmobilisationFixeEJB immobFixeEJB = new ImmobilisationFixeEJB();
	PassifCourantEJB passifcourantEjb = new PassifCourantEJB();
	PassifNonCourantEJB passifNNcourantEjb = new PassifNonCourantEJB();

	@Override
	public void AddBilan(Bilan bilan) {
		em.persist(bilan);
	}

	@Override
	public void removeBilan(Bilan bilan) {
		// TODO Auto-generated method stub
		em.remove(bilan);

	}

	@Override
	public void updateBilan(Bilan bilan) {
		// TODO Auto-generated method stub
		em.persist(bilan);

	}

	@Override
	public Bilan FindCurrentBilan() {
		// TODO Auto-generated method stub
		TypedQuery<Bilan> query = em
				.createQuery("SELECT Bilan b WHERE EXTRACT(YEAR,b.date)= EXTRACT(YEAR,CURRENT_DATE)", Bilan.class);

		return query.getSingleResult();
	}

	@Override
	public Bilan FindBilanBydate(Date date) {
		TypedQuery<Bilan> query = em.createQuery("SELECT Bilan b WHERE EXTRACT(YEAR,b.date)= EXTRACT(YEAR,:date)",
				Bilan.class);
		query.setParameter("date", date, TemporalType.DATE);
		return query.getSingleResult();
	}

	@Override
	public Double CalculerResultatDexercice(Bilan bilan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double CalculTotaleActifs(Bilan bilan) {

		return immobFixeEJB.CalculTotalImmoblisationFixe(bilan.getImmobFixe());
	}

	@Override
	public Double CalculTotalePassif(Bilan bilan) {
		Double totale =passifNNcourantEjb.CalculTotalePassifNonCourant(bilan.getPassifNonCourant())
				+ passifcourantEjb.CalculToTalePassifCourant(bilan.getPassifCourant());
	
		return  totale;}

}
