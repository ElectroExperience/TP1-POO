package exceptions;

import main.Animal;
import main.Secteur;

public class AnimalDansMauvaisSecteurException extends Exception{
	
	Animal animal;
	Secteur secteur;

	public AnimalDansMauvaisSecteurException(Animal animal, Secteur secteur) {
		super();
		this.animal = animal;
		this.secteur = secteur;
	}

	
	
	public String toString() {
		return "L'animal \"" + animal.getTypeAnimal() + "\" ne peut être ajouté car le secteur est de type \"" + 
				secteur.obtenirType() + "\"";
	}
	
}
