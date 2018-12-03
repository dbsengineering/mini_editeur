package command;

public class RePlay implements Command<Boolean>{

	// --- Déclaration des propriétées ---
	private memento.CareTaker recorder; // L'enregistreur

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver
	 */
	public RePlay(memento.CareTaker recorder) {
		this.recorder = recorder;
	}
	
	/**
	 * Procédure qui execute la commande
	 */
	public void execute(Boolean block) {
		//Si on enregistre pas, on peut faire lecture
		if(!block) {
			this.recorder.rePlay();
		}
	}
}
