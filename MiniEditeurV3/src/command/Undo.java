package command;


public class Undo implements Command {
	
	// --- Déclaration des propriétées ---
	private memento.CareTaker recorder;// L'enregistreur de commandes
	
	/**
	 * Constructeur de la classe.
	 * @param receiver
	 */
	public Undo(memento.CareTaker recorder) {
		this.recorder = recorder;
	}
	
	/**
	 * Procédure d'execution de la commande undo.
	 */
	@Override
	public void execute() {
		this.recorder.undo();
	}

}
