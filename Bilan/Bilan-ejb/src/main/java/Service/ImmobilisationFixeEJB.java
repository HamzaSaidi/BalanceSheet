package Service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Bilan;
import Entities.ImmobilisationFixe;
import Interfaces.IimmobilisationFixe;

@Stateless
@Remote
public class ImmobilisationFixeEJB implements IimmobilisationFixe {
	@PersistenceContext
	EntityManager em;

	ImmobilisationCorporelleEJB immobCorporelleEJB = new ImmobilisationCorporelleEJB();
	ImmoblisationNonCorporelleEJB immobNonCorporelleEJB = new ImmoblisationNonCorporelleEJB();
	BilanEJB bilanEJB = new BilanEJB();
	private Double totale;

	@Override
	public void AddImmobFixe(ImmobilisationFixe immobilisationFixe) {
		em.persist(immobilisationFixe);

	}

	@Override
	public void removeImmobFixe(ImmobilisationFixe fixe) {
		em.remove(fixe);

	}

	@Override
	public void updateImmbFixe(ImmobilisationFixe immobilisationFixe) {
		Bilan bilanCurrent = bilanEJB.FindCurrentBilan();
		if (bilanCurrent == null) {
			bilanCurrent = new Bilan();

		}
		immobilisationFixe.setBilan(bilanCurrent);
		;
		em.persist(immobilisationFixe);

	}

	@Override
	public List<ImmobilisationFixe> FindCurrentImmobFixe() {
		List<ImmobilisationFixe> list = null;
		TypedQuery<ImmobilisationFixe> query = em.createQuery(
				"SELECT ImmobilisationFixe immob WHERE EXTRACT(YEAR,immob.date)" + "= EXTRACT(YEAR,CURRENT_DATE)" + "",
				ImmobilisationFixe.class);
		list = query.getResultList();
		return list;

	}

	@Override
	public Double CalculTotalImmoblisationFixe(ImmobilisationFixe immobilisationfixe) {

		// Calcul de la somme immob corporelle et non corporelle
		totale = null;
		totale += immobCorporelleEJB.CalculTotalImmobilisationCorporelle(immobilisationfixe.getImmobCorporelles())
				+ immobNonCorporelleEJB
						.CalculTotalImmobilisationNonCorporelle(immobilisationfixe.getImmobNonCorporelles());

		return totale;

	}

}
