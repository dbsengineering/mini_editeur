/********************************************************************
 * 						Classe ConcretMCopier						*
 * 					Mémento concret de copier.						*
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

public class ConcretMCopier implements Memento<Integer> {

	// --- Déclaration des propriétées ---
	private final String TYPE = "Copier";
	private Integer lng;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param lng : Integer
	 */
	public ConcretMCopier(Integer lng) {
		this.lng = lng;
	}

	// --- Getters ---

	/**
	 * Fonction qui retourne le type du ConcretMCopier.
	 * 
	 * @return TYPE : String.
	 */
	public String getType() {
		return this.TYPE;
	}
	
	/**
	 * Fonction qui retourne la valeur du paramètre de la commande.
	 * 
	 * @return lng : Integer
	 */
	public Integer getSavedValue() {
		return this.lng;
	}
}
