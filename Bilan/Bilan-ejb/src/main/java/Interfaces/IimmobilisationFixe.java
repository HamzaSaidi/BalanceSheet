package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.ImmobilisationFixe;
@Remote
public interface IimmobilisationFixe {

	public void AddImmobFixe(ImmobilisationFixe immobilisationFixe);

	public void removeImmobFixe(ImmobilisationFixe fixe);

	public void updateImmbFixe(ImmobilisationFixe immobilisationFixe);

	public  List<ImmobilisationFixe>  FindCurrentImmobFixe();
	
	public Double CalculTotalImmoblisationFixe(ImmobilisationFixe immobilisationfixe);
	
	
}
