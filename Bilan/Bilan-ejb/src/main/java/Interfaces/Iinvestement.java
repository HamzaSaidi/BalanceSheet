package Interfaces;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ejb.Remote;

import Entities.Investement;
@Remote
public interface Iinvestement {
	public void AjouterInvestement(Investement investement);

	public Investement ConstruireInvestementParFacture(File facture) throws  IOException,NumberFormatException;// tesseract

	public void SupprimerInvestement(Investement investement);

	public List<Investement> FindAllInvestement();

	public List<Investement> FindByType(String Type);

	public List<Investement> FindByPrice(Double montant);

}
