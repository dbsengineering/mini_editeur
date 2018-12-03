package command;

public class Redo implements Command {

	// --- Déclaration des propriétées ---
	private memento.CareTaker recorder;// L'enregistreur de commandes

	/**
	 * Constructeur de la classe.
	 * @param receiver
	 */
	public Redo(memento.CareTaker recorder) {
		this.recorder = recorder;
	}

	/**
	 * Procédure d'execution de la commande Redo.
	 */
	@Override
	public void execute() {
		this.recorder.redo();
	}

}
