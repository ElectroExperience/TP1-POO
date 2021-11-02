package main;
import java.util.ArrayList;
import java.util.List;

import exceptions.AnimalDansMauvaisSecteurException;

public class Secteur {
	
	private TypeAnimal typeAnimauxDansSecteur;
	private List<Animal> animauxDansSecteur;
	
	public Secteur(TypeAnimal typeAnimauxDansSecteur) {
		super();
		this.typeAnimauxDansSecteur = typeAnimauxDansSecteur;
		animauxDansSecteur = new ArrayList<Animal>();
	}

	public void ajouterAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
		if(animal.getTypeAnimal() != typeAnimauxDansSecteur)
			throw new AnimalDansMauvaisSecteurException(animal, this);
		animauxDansSecteur.add(animal);
	}
	

	public int getNombreAnimaux() {
		return animauxDansSecteur.size();
	}
	
	public TypeAnimal obtenirType() {
		return typeAnimauxDansSecteur;
	}
	
	

}
