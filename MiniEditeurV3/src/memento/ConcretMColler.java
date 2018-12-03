/********************************************************************
 * 						Classe ConcretMColler						*
 * 					Mémento concret de coller.						*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 06/12/2017								*
 *		DateModify : ...... 06/12/2017								*
 *******************************************************************/
package memento;

public class ConcretMColler implements Memento {

	// --- Déclaration des propriétées ---
	private State state; // Etat su mémento.
	private final String TYPE = "Coller"; // Type du mémento.

	/**
	 * Constructeur de la classe.
	 */
	public ConcretMColler() {
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
