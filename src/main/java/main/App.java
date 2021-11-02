package main;

import animaux.Chat;
import animaux.Chien;

public class App {
	
	
	
	
	
	
	
	private static Zoo zoo;

	public static void main(String[] args) throws Exception {
		
		zoo = new Zoo();
		
		zoo.ajouterSecteur(TypeAnimal.CHAT);
		zoo.ajouterSecteur(TypeAnimal.CHIEN);
		
		zoo.nouvelAnimal(new Chat());
		zoo.nouvelAnimal(new Chien());
		
		while(true) {
			zoo.nouveauVisiteur();
			System.out.println("Nombre de visiteurs : " + zoo.getNbVisiteurs() + "/" + zoo.getLimiteVisiteur());
		}
		

	}

}
