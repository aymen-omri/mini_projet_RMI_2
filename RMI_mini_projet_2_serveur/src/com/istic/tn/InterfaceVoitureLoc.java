package com.istic.tn;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InterfaceVoitureLoc extends Remote {
	public String ajouterVoiture(VoitureLoc voiture) throws RemoteException ;
	public List<VoitureLoc> rechercheVoiture(String marque) throws RemoteException ; 
	public String verifpreference(VoitureLoc voiture) throws RemoteException ; 
	public int plusCher() throws RemoteException;
	public String dureeLoc(int x) throws RemoteException;
	public String validerReservation(VoitureLoc voiture) throws RemoteException;

}
