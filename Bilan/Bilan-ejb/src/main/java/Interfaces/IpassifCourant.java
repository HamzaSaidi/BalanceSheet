package Interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.PassifCourant;
 
@Remote
public interface IpassifCourant {
	public void AddPassifCourant(PassifCourant passifcourant);

	public void RemovePassifCourant(PassifCourant passifcourant);

	public void UpdatePassifCourant(PassifCourant passifcourant);

	public PassifCourant FindCurrentPassifCourant();

	public List<PassifCourant> FindPassifCourantBYDateIntervalle(Date startDate,Date endDate);
	public Double CalculToTalePassifCourant(PassifCourant passifcourant);
	}
 