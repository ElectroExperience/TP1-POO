package animaux;

import main.Animal;
import main.TypeAnimal;

public class Chat extends Animal {
	
	public Chat() {
		super(TypeAnimal.CHAT);
	}
	
	public String getNomAnimal() {
		return "Chat";
	}
	
}
