/********************************************************************
 * 						Classe OriginCopier							*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande Copier.								*
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

public class OriginCopier extends command.Copier implements OriginatorInter<Integer> {
	
	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private Integer lng;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginCopier(receiver.MoteurEd receiver, CareTaker recorder) {
		super(receiver);
		this.recorder = recorder;
	}
	
	// --- Getters ---

	/**
	 * Procédure d'execution de la commande.
	 * 
	 * @param lng : Integer
	 */
	@Override
	public void execute(Integer lng) {
		this.lng = lng;
		this.recorder.recCommand(this);
		super.execute(lng);
	}

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * 
	 * @return ConcretMCopier : Memento
	 */
	@Override
	public Memento<Integer> getMemento() {
		return new ConcretMCopier(this.lng);
	}
	
	// --- Setters ---

	/**
	 * Procédure qui modifie le mémento de la commande.
	 * 
	 * @param memento : Memento
	 * @param lng : Integer
	 */
	@Override
	public void setMemento(Memento<Integer> memento) {
		super.execute(memento.getSavedValue());
	}
}
