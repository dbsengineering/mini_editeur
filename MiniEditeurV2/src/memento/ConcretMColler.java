/********************************************************************
 * 						Classe ConcretMColler						*
 * 					Mémento concret de coller.						*
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

public class ConcretMColler implements Memento<Integer> {

	// --- Déclaration des propriétées ---
	private final String TYPE = "Coller";
	private Integer deb;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param deb : Integer
	 */
	public ConcretMColler(Integer deb) {
		this.deb = deb;
	}

	// --- Getters ---

	/**
	 * Fonction qui retourne le type du ConcretMColler.
	 * 
	 * @return TYPE : String.
	 */
	public String getType() {
		return this.TYPE;
	}
	
	/**
	 * Fonction qui retourne la valeur du paramètre de la commande.
	 * 
	 * @return deb : Integer
	 */
	public Integer getSavedValue() {
		return this.deb;
	}
}
