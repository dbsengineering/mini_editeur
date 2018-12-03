/********************************************************************
 * 						Classe OriginInsertTxt						*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande InsertTxt.							*
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

public class OriginInsertTxt extends command.InsertTxt implements OriginatorInter<Character> {

	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private Character caractere;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginInsertTxt(receiver.MoteurEd receiver, CareTaker recorder) {
		super(receiver);
		this.recorder = recorder;
	}

	/**
	 * Procédure d'execution de la commande.
	 * 
	 * @param caractere : Character
	 */
	@Override
	public void execute(Character caractere) {
		this.caractere = caractere;
		this.recorder.recCommand(this);
		super.execute(caractere);
	}
	
	// --- Getters ---

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * 
	 * @return ConcretMCouper : Memento
	 */
	@Override
	public Memento<Character> getMemento() {
		return new ConcretMInsertTxt(this.caractere);
	}
	
	/**
	 * Fonction qui retourne le caractere inséré.
	 * 
	 * @return caractere : Character
	 */
	/*@Override
	public Character getParams() {
		return this.caractere;
	}*/
	
	// --- Setters ---

	/**
	 * Procédure qui modifie le mémento de la commande.
	 * 
	 * @param memento : Memento
	 * @param caractere : Character
	 */
	@Override
	public void setMemento(Memento<Character> memento) {
		super.execute(memento.getSavedValue());
	}
}
