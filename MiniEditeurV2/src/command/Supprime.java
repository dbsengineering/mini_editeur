package command;

public class Supprime implements Command<int[]>{
	
	// --- Déclaration des propriétées ---
	receiver.MoteurEd receiver; // Le recepteur
	
	/**
	 * Constructeur de la classe
	 * @param receiver
	 */
	public Supprime(receiver.MoteurEd receiver) {
		this.receiver = receiver;
	}
	
	/**
	 *  Procédure de l'execution de la commande
	 *  @param pos : int[] . debut / fin
	 */
	@Override
	public void execute(int[] pos) {
		this.receiver.supprimer(pos);
	}
}
