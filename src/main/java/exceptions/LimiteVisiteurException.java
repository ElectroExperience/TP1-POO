package exceptions;

public class LimiteVisiteurException extends Exception {
	
	int maxVisiteurs;
	
	public LimiteVisiteurException(int maxVisiteurs) {
		this.maxVisiteurs = maxVisiteurs;
	}
	
	
	public String toString() {
		return "Nombre max de visiteurs atteint (" + maxVisiteurs + ") : Impossible d'en rajouter un autre";
	}

}
