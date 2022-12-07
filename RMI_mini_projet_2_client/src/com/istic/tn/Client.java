package com.istic.tn;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client{

	public static void main(String[] args) {
		try {
			InterfaceVoitureLoc ivl = (InterfaceVoitureLoc) Naming.lookup("rmi://localhost:1099/Voiture");
			
			VoitureLoc voiture1 = new VoitureLoc(3,4,"marque2","noir",12000,(float) 85.3);
			VoitureLoc voiture2 = new VoitureLoc(4,8,"marque2","blanc",3000,(float) 78.235);
			VoitureLoc voiture3 = new VoitureLoc(6,4,"marque4","vert",45889,855);

			System.out.println(ivl.ajouterVoiture(voiture1));
			System.out.println(ivl.ajouterVoiture(voiture2));
			System.out.println(ivl.ajouterVoiture(voiture3));
			
			List<VoitureLoc> voitures = new ArrayList<VoitureLoc>();
			voitures.add(voiture1);
			voitures.add(voiture2);
			voitures.add(voiture3);
			
			System.out.println("******************************************");


			Scanner sc = new Scanner(System.in);
			
			System.out.println("=>Tapez 1 pour ajouter une voiture\n=>Tapez 2 pour chercher une voiture par marque."
					+ "\n=>Tapez 3 pour trouver la voiture ayant le prix le plus eleve."
					+ "\n=>Tapez 4 pour prêter une voiture.");
			
			
			int num = sc.nextInt();
				if(num==1) {
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Donner l'id");
					int id = sc1.nextInt();
					System.out.println("Donner Nombre voiture disponible");
					int nb = sc1.nextInt();
					System.out.println("Donner marque");
					Scanner sc2 = new Scanner(System.in);
					String marque = sc2.nextLine();
					System.out.println("Donner couleur");
					String couleur = sc2.nextLine();
					System.out.println("Donner prix par jour");
					float prix = sc2.nextInt();
					System.out.println("Donner consommation");
					float con = sc2.nextFloat();
					
					VoitureLoc voiture = new VoitureLoc(id,nb,marque,couleur,prix,con);
					
					voitures.add(voiture);
					
					System.out.println(ivl.ajouterVoiture(voiture));
					
					System.out.println("verif: "+ ivl.verifpreference(voiture));


				}else if(num==2) {
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Donnez marque");
					String marque=sc3.nextLine();
					System.out.println(ivl.rechercheVoiture(marque));
					
				}else if(num==3) {
					int idCher = ivl.plusCher();
					for(int i = 0 ; i<voitures.size();i++) {
						if(voitures.get(i).getId()==idCher) {
							System.out.println(voitures.get(i).toString());
						}
					}
					
				}else if(num==4) {
					VoitureLoc vChoisi = null ;  
					Scanner scc = new Scanner(System.in);
					System.out.println("donner l'id de voiture a preter");
					int idp = scc.nextInt();
					for(int i=0 ; i<voitures.size();i++) {
						if(voitures.get(i).getId() == idp) {
							vChoisi = voitures.get(i);
							break;
						}
					}
					
					if(vChoisi!=null) {
						Scanner sc4 = new Scanner(System.in);
						System.out.println("Donner duree loc");
						int duree = sc4.nextInt();
						System.out.println(ivl.dureeLoc(duree));
						Scanner sc5 = new Scanner(System.in);
						System.out.println("Valider la reservation(oui/non):");
						String reponse = sc5.nextLine();
						if(reponse.equals("oui")) {
							System.out.println(ivl.validerReservation(vChoisi));
						}else if(reponse.equals("non")) {
							System.out.println("ok");
						}else {
							System.out.println("mauvais choix");
						}
					}else {
						System.out.println("id n'existe pas!");
					}	
				}else {
					System.out.println("mauvais choix!");
				}
							
			
			
			
		}catch(Exception e)  {
			System.out.println ("Erreur d’accès à l’objet distant");
			System.out.println (e.toString());
		}

	}

}
