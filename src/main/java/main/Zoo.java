package main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import animaux.Chien;
import exceptions.AnimalDansMauvaisSecteurException;
import exceptions.LimiteVisiteurException;


public class Zoo {
	
	
	private int visiteurs;
	private static int nbvisiteurMaxParSecteur = 15;
	private List<Secteur> secteursAnimaux;
	
	
	
	
	public Zoo() {
		secteursAnimaux = new ArrayList<Secteur>();
	}

	public void ajouterSecteur(TypeAnimal typeAnimal) {
		secteursAnimaux.add(new Secteur(typeAnimal));
	}
	
	public void nouveauVisiteur() throws LimiteVisiteurException{
		if(nbvisiteurMaxParSecteur*secteursAnimaux.size() <= visiteurs) {
			throw new LimiteVisiteurException(nbvisiteurMaxParSecteur*secteursAnimaux.size());
		}
		visiteurs++;
	}
	
	public int getLimiteVisiteur() {
		return nbvisiteurMaxParSecteur*secteursAnimaux.size();
	}
	
	public int getNbVisiteurs() {
		return visiteurs;
	}
	
	public void nouvelAnimal(Animal animal) throws AnimalDansMauvaisSecteurException{
		for(Secteur s : secteursAnimaux) {
			if(s.obtenirType() == animal.getTypeAnimal()) {
				s.ajouterAnimal(animal);
				break;
			}
		}
	}
	
	public int getNbAnimaux() {
		int nb = 0;
		for(Secteur s : secteursAnimaux) {
			nb += s.getNombreAnimaux();
		}
		
		return nb;
	}
	
	
	
	
	@Test
	public void testNbVisiteurs(){
		ajouterSecteur(TypeAnimal.CHAT);
		try {
			while(true) {
				nouveauVisiteur();
				System.out.println("Nombre de visiteurs : " + getNbVisiteurs() + "/" + getLimiteVisiteur());
			}
		}catch(LimiteVisiteurException e) {
			System.out.println("Exception levée");
			return;
		}
	}
	
	
	@Test
	public void testChien() throws Exception{
		ajouterSecteur(TypeAnimal.CHAT);
		ajouterSecteur(TypeAnimal.CHIEN);
		
		Chien chien = new Chien();
		
		nouvelAnimal(chien);
		
		for(Secteur s : secteursAnimaux) 
			if(s.getNombreAnimaux() != 0) {
				if(s.obtenirType() == TypeAnimal.CHIEN) 
					return;
				else 
					throw new AnimalDansMauvaisSecteurException(chien, s);
			}
	}
	
	
	
}
