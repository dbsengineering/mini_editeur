/********************************************************************
 * 						Classe ConcretMSupprime						*
 * 					Mémento concret de supprime.					*
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

public class ConcretMSupprime implements Memento<int[]> {

	// --- Déclaration des propriétées ---
	private final String TYPE = "Supp";
	private int[] pos;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param pos : int[]
	 */
	public ConcretMSupprime(int[] pos) {
		this.pos = pos;
	}

	// --- Getters ---

	/**
	 * Fonction qui retourne le type de ConcretMSupprime
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
