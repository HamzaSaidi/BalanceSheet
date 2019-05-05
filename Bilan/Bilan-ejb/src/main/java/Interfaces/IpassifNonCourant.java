package Interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.PassifNonCourant;

@Remote
public interface IpassifNonCourant{
	
	public void AddPassifNoncourant(PassifNonCourant passifnncourant);

	public void RemovePassifNoncourant(PassifNonCourant passifnncourant);

	public void UpdatePassifNoncourant(PassifNonCourant passifnncourant);

	public PassifNonCourant FindCurrentPassifNoncourant();

	public List<PassifNonCourant> FindPassifNoncourantBYDateIntervalle(Date startDate,Date endDate);
	
	public Double CalculTotalePassifNonCourant(PassifNonCourant passifnncourant);


}
