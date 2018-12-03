/********************************************************************
 * 						Classe OriginSupprime						*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande Supprime.							*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 21/11/2017								*
 *		DateModify : ...... 21/11/2017								*
 *******************************************************************/
package memento;

public class OriginSupprime extends command.Supprime implements OriginatorInter<int[]> {

	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private int[] pos;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginSupprime(receiver.MoteurEd receiver, CareTaker recorder) {
		super(receiver);
		this.recorder = recorder;
	}

	/**
	 * Procédure d'execution de la commande.
	 * 
	 * @param pos : int[]
	 */
	@Override
	public void execute(int[] pos) {
		this.pos = pos;
		this.recorder.recCommand(this);
		super.execute(pos);
	}
	
	// --- Getters ---

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * 
	 * @return ConcretMCouper : Memento
	 */
	@Override
	public Memento<int[]> getMemento() {
		return new ConcretMSupprime(this.pos);
	}
	
	// ---Setters ---

	/**
	 * Procédure qui modifie le mémento de la commande.
	 * 
	 * @param memento : Memento
	 * @param pos : int[]
	 */
	@Override
	public void setMemento(Memento<int[]> memento) {
		super.execute(memento.getSavedValue());
	}
}
