package animaux;

import main.Animal;
import main.TypeAnimal;

public class Chien extends Animal {
	
	public Chien() {
		super(TypeAnimal.CHIEN);
	}

	public String getNomAnimal() {
		return "Chien";
	}
	
}
