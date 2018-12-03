/********************************************************************
 * 						Classe ConcretMInsertTxt					*
 * 					Mémento concret de insertTxt.					*
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

public class ConcretMInsertTxt implements Memento<Character> {

	// --- Déclaration des propriétées ---
	private final String TYPE = "Insert";
	private Character caractere;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param caractere : Character
	 */
	public ConcretMInsertTxt(Character caractere) {
		this.caractere = caractere;
	}

	// --- Getters ---

	/**
	 * Fonction qui retourne le type de ConcretMInsertTxt
	 * 
	 * @return TYPE : String
	 */
	public String getType() {
		return this.TYPE;
	}
	
	/**
	 * Fonction qui retourne la valeur du paramètre de la commande.
	 * 
	 * @return caractere : Character
	 */
	public Character getSavedValue() {
		return this.caractere;
	}
}
