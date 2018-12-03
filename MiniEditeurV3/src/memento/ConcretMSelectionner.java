/********************************************************************
 * 						Classe ConcretMSelectionner					*
 * 					Mémento concret de selectionner.				*
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

public class ConcretMSelectionner implements Memento {

	// --- Déclaration des propriétées ---
	private State state; // Etat su mémento.
	private final String TYPE = "Select"; // Type du mémento.

	/**
	 * Constructeur de la classe.
	 */
	public ConcretMSelectionner() {
		this.state = new State();
	}

	/**
	 * Procédure qui permet d'initialiser l'état du mémento.
	 * 
	 * @param state : State.
	 */
	public void setState(State state) {
		this.state = state;
	}

	// --- Getters ---

	/**
	 * Fonction qui retourne l'état du mémento.
	 * 
	 * @return state : State.
	 */
	public State getState() {
		return this.state;
	}

	/**
	 * Fonction qui retourne le type du mémento.
	 * 
	 * @return TYPE : String.
	 */
	@Override
	public String getType() {
		return this.TYPE;
	}
}
