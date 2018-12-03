/********************************************************************
 * 						Classe ConcretMCouper						*
 * 					Mémento concret de couper.						*
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

public class ConcretMCouper implements Memento<int[]> {

	// --- Déclaration des propriétées ---
	private final String TYPE = "Couper";
	private int[] pos;
	
	/**
	 * Constructeur de la classe.
	 * 
	 * @param pos : int[]
	 */
	public ConcretMCouper(int[] pos) {
		this.pos = pos;
	}

	// --- Getters ---

	/**
	 * Fonction qui retourne le type de ConcretMCouper
	 * 
	 * @return TYPE : String
	 */
	public String getType() {
		return this.TYPE;
	}
	
	/**
	 * Fonction qui retourne la valeur du paramètre de la commande.
	 * 
	 * @return pos : int[] . position de la sélection.
	 */
	public int[] getSavedValue() {
		return this.pos;
	}
}
