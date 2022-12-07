package com.istic.tn;

import java.io.Serializable;

public class VoitureLoc implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id ; 
	int NombreVoitureDisponible ; 
	String marque;
	String couleur ; 
	float prixParJour;
	float consommation;
	public VoitureLoc(int id, int nombreVoitureDisponible, String marque, String couleur, float prixParJour,
			float consommation) {
		super();
		this.id = id;
		NombreVoitureDisponible = nombreVoitureDisponible;
		this.marque = marque;
		this.couleur = couleur;
		this.prixParJour = prixParJour;
		this.consommation = consommation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNombreVoitureDisponible() {
		return NombreVoitureDisponible;
	}
	public void setNombreVoitureDisponible(int nombreVoitureDisponible) {
		NombreVoitureDisponible = nombreVoitureDisponible;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public float getPrixParJour() {
		return prixParJour;
	}
	public void setPrixParJour(float prixParJour) {
		this.prixParJour = prixParJour;
	}
	public float getConsommation() {
		return consommation;
	}
	public void setConsommation(float consommation) {
		this.consommation = consommation;
	}
	@Override
	public String toString() {
		return "VoitureLoc [id=" + id + ", NombreVoitureDisponible=" + NombreVoitureDisponible + ", marque=" + marque
				+ ", couleur=" + couleur + ", prixParJour=" + prixParJour + ", consommation=" + consommation + "]";
	}
	

}

