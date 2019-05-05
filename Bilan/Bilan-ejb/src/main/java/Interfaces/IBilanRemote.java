package Interfaces;

import java.util.Date;

import javax.ejb.Remote;

import Entities.Bilan;

@Remote
public interface IBilanRemote {
	public void AddBilan(Bilan bilan);
	public void removeBilan(Bilan bilan);
	public void updateBilan(Bilan bilan);
	public Bilan FindCurrentBilan();
	public Bilan FindBilanBydate(Date date);
	public Double CalculerResultatDexercice(Bilan bilan);
	public Double CalculTotaleActifs(Bilan bilan);
	public Double CalculTotalePassif(Bilan bilan);
	

}
