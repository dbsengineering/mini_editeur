/********************************************************************
 * 						Classe PressePapier							*
 * 																	*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 15/10/2017								*
 *******************************************************************/
package receiver;


/**
 * 
 */
public class PressPapier {

    //--- Déclaration des propriétées ---
    private String contenu;

    /**
     * Constructeur de la classe.
     */
    public PressPapier() {
    	this.contenu = "";
    }

    /**
     * Fonction qui retourne le contenu du press papier.
     * 
     * @return contenu : String
     */
    public String getContenu() {
        return this.contenu;
    }

    /**
     * Procédure qui permet de modifier le contenu du press papier.
     * 
     * @param contenu : String
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}