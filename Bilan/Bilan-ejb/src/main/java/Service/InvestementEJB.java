package Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

 import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.ImmobilisationCorporelle;
import Entities.ImmobilisationNonCorporelle;
import Entities.Investement;
import Entities.InvestementType;
import Interfaces.Iinvestement;

@Stateless
public class InvestementEJB implements Iinvestement {
	@PersistenceContext
	EntityManager em;
	
	ImmobilisationCorporelleEJB immobCrprl = new ImmobilisationCorporelleEJB();
	
	ImmoblisationNonCorporelleEJB immobNonCrprl = new ImmoblisationNonCorporelleEJB();

	@Override
	public void AjouterInvestement(Investement investement) {
		
		if (!investement.getType().equals(InvestementType.trade)
				&& !investement.getType().equals(InvestementType.software)) {
			ImmobilisationCorporelle immob = immobCrprl.FindByDate(investement.getDate());
			if (immob==null) {
				 immob=new  ImmobilisationCorporelle();
				
			}
			investement.setImmobCrpl(immob);

		} else {
			
			ImmobilisationNonCorporelle immobnn = immobNonCrprl.FindByDate(investement.getDate());
			if (immobnn==null) {
				immobnn=new ImmobilisationNonCorporelle();
				
			}
			investement.setImmobNonCrpl(immobnn);

		}
		em.persist(investement);
	}

	@Override
	public Investement ConstruireInvestementParFacture(File facture) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SupprimerInvestement(Investement investement) {
		// TODO Auto-generated method stub
		em.remove(investement);
	}

	@Override
	public List<Investement> FindAllInvestement() {
		TypedQuery<Investement> query = em.createQuery("SELECT Investement From Investement", Investement.class);
		List<Investement> list = query.getResultList();
		return list;
	}

	@Override
	public List<Investement> FindByType(String Type) {
		TypedQuery<Investement> query = em.createQuery(
				"SELECT Investement From Investement where Investement.type=" + Type + "", Investement.class);
		List<Investement> list = query.getResultList();
		return list;
	}

	@Override
	public List<Investement> FindByPrice(Double montant) {
		TypedQuery<Investement> query = em.createQuery(
				"SELECT Investement From Investement where Investement.montant=" + montant + "", Investement.class);
		List<Investement> list = query.getResultList();

		return list;

	}

}
