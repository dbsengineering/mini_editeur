/********************************************************************
 * 						Classe OriginColler							*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande Coller.								*
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

public class OriginColler extends command.Coller implements OriginatorInter<Integer> {

	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private Integer deb;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginColler(receiver.MoteurEd receiver, CareTaker recorder) {
		super(receiver);
		this.recorder = recorder;
	}

	/**
	 * Procédure d'execution de la commande.
	 * 
	 * @param deb : Integer
	 */
	@Override
	public void execute(Integer deb) {
		this.deb = deb;
		this.recorder.recCommand(this);
		super.execute(deb);
	}
	
	// --- Getters ---

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * 
	 * @return ConcretMCouper : Memento
	 */
	@Override
	public Memento<Integer> getMemento() {
		return new ConcretMColler(this.deb);
	}
	
	// --- Setters ---

	/**
	 * Procédure qui modifie le mémento de la commande.
	 * 
	 * @param memento : Memento
	 * @param deb : Integer
	 */
	@Override
	public void setMemento(Memento<Integer> memento) {
		super.execute(memento.getSavedValue());
	}
}
