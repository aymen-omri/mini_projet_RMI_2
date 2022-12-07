package com.istic.tn;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ClasseServeur extends UnicastRemoteObject implements InterfaceVoitureLoc {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<VoitureLoc> liste_voitures = new ArrayList<VoitureLoc>();
	protected ClasseServeur() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ajouterVoiture(VoitureLoc voiture) throws RemoteException {
		liste_voitures.add(voiture);
		return "Vous avez ajouté "+liste_voitures.size()+" voitures" ;
	}

	@Override
	public List<VoitureLoc> rechercheVoiture(String marque) throws RemoteException {
		int somme = 0 ;
		List<VoitureLoc> voitures = new ArrayList<VoitureLoc>();
		for(int i=0 ; i<liste_voitures.size();i++) {
			somme = somme + liste_voitures.get(i).getNombreVoitureDisponible();
			if(liste_voitures.get(i).getMarque().equals(marque)) {
				voitures.add(liste_voitures.get(i));
			}
		}
		System.out.println("Il ya "+somme+"voiture(s) disponibles.");
		return voitures;
	}

	@Override
	public String verifpreference(VoitureLoc voiture) throws RemoteException {
		for(int i=0 ; i<liste_voitures.size();i++) {
			if(liste_voitures.get(i).getPrixParJour()>5000) {
				return "Valide";
			}
		}
		return "Non valide";
	}

	@Override
	public int plusCher() throws RemoteException {
		float prix = 0 ; 
		int idc = 0 ;
		for(int i = 0 ; i<liste_voitures.size() ; i++) {
			if(liste_voitures.get(i).getPrixParJour()>prix) {
				prix = liste_voitures.get(i).getPrixParJour();
				idc = liste_voitures.get(i).getId();
			}
		}
		return idc ; 
	}

	@Override
	public String dureeLoc(int x) throws RemoteException {
		return "duree loc: "+x+"j";
	}

	@Override
	public String validerReservation(VoitureLoc voiture) throws RemoteException {
		return voiture.toString();
	}

}
