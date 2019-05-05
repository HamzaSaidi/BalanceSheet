package Interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.ImmobilisationCorporelle;

@Remote
public interface IimmobilisationCorporelle {
	
	public void AddImmobilsationCorporelle(ImmobilisationCorporelle immobCrprl);
	public Double CalculTotalImmobilisationCorporelle(ImmobilisationCorporelle ImmobCrprl);
	public List<ImmobilisationCorporelle> FindCurrentImmoblisationsCorporelles() ;

	public List<ImmobilisationCorporelle> FindByDateIntervalle(Date startdate,Date endDate);
	public List<ImmobilisationCorporelle> FindByPriceSup(Double prix);
	public List<ImmobilisationCorporelle> FindByPriceInf(Double prix);
	public ImmobilisationCorporelle FindByDate(Date date);

	
	

}
