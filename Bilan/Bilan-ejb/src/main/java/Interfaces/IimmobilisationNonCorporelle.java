package Interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.ImmobilisationNonCorporelle;

@Remote
public interface IimmobilisationNonCorporelle {
	public void AddImmobilsationCorporelle(ImmobilisationNonCorporelle immobNonCrprl);

	public Double CalculTotalImmobilisationNonCorporelle(ImmobilisationNonCorporelle immobNonCorporelle);
	public List<ImmobilisationNonCorporelle> FindCurrentImmoblisationsNonCorporelles() ;
	public List<ImmobilisationNonCorporelle> FindByDateIntervalle(Date startdate, Date endDate);
	public ImmobilisationNonCorporelle FindByDate(Date date);

	public List<ImmobilisationNonCorporelle> FindByPriceSup(Double prix);

	public List<ImmobilisationNonCorporelle> FindByPriceInf(Double prix);

}
