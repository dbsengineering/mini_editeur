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

public class ConcretMSelectionner implements Memento<int[]> {

	// --- Déclaration des propriétées ---
	private final String TYPE = "Select";
	private int[] pos;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param pos : int[]
	 */
	public ConcretMSelectionner(int[] pos) {
		this.pos = pos;
	}

	// --- Getters ---

	/**
	 * Fonction qui retourne le type de ConcretMSelectionner
	 * 
	 * @return TYPE : String
	 */
	public String getType() {
		return this.TYPE;
	}
	
	/**
	 * Fonction qui retourne la valeur de la commande.
	 * 
	 * @return pos : int[]
	 */
	public int[] getSavedValue() {
		return this.pos;
	}
}
