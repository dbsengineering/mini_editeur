package command;

public class Supprime implements Command {
	
	// --- Déclaration des propriétées ---
	private receiver.MoteurEd receiver; // Le recepteur
	
	/**
	 * Constructeur de la classe
	 * @param receiver
	 */
	public Supprime(receiver.MoteurEd receiver) {
		this.receiver = receiver;
	}
	
	/**
	 *  Procédure de l'execution de la commande
	 */
	@Override
	public void execute() {
		this.receiver.supprimer();
	}
}
