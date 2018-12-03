/********************************************************************
 * 						Classe Select								*
 * 					permet de sélectionner un texte					*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 16/10/2017								*
 *******************************************************************/
package receiver;

/**
 * 
 */
public class Select {

    // --- Déclaration des propriétées ---
    private int deb;
    private int lng;

    /**
     * Constructeur de la classe.
     */
    public Select() {}

    // --- Getters ---
    /**
     * Fonction qui retourne le début de la sélection.
     * 
     * @return deb : int
     */
    public int getDebut() {
        return this.deb;
    }

    /**
     * Fonction qui retourne la longueur de la sélection.
     * 
     * @return lng : int
     */
    public int getLng() {
        return this.lng;
    }
    
    // --- Setters ---
    /**
	 * Procédure qui modifie le début de la sélection.
	 * 
	 * @param debut : int
	 */
	public void setDebut(int deb) {
		this.deb = deb;
	}
    
	/**
	 * Procédure qui modifie la longueur de la sélection
	 * 
	 * @param lng : int
	 */
    public void setLng(int lng) {
    	if (lng > 0) {
			this.lng = lng;
		} else {
			this.lng = 0;
		}
    }
}