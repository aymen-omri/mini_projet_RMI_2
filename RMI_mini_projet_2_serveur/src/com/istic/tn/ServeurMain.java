package com.istic.tn;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurMain {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			ClasseServeur vt=new ClasseServeur();
			Naming.rebind("Voiture",vt);
			} catch (Exception e) {
			e.printStackTrace();
			}

	}

}
