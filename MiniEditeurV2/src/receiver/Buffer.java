/********************************************************************
 * 						Classe Buffer								*
 * 					Mémoire tampon									*
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
public class Buffer {
	
	//--- Déclaration des propriétées ---
	private StringBuffer sBuffer;

    /**
     * COnstructeur de la classe Buffer.
     */
    public Buffer() {
    	sBuffer = new StringBuffer();
    }
    
    //--- Méthodes Buffer ---
    
    /**
     * procédure qui permet de supprimer un ou plusieurs caractères
     * dans le buffer.
     * 
     * @param pos : position sélection, longueur de la sélection.
     */
    public void supprimer(int[] pos) {
    	if (pos[1] > 0) {
    		try {
    			this.sBuffer.delete(pos[0], pos[0]+pos[1]);
    		}catch(Exception e) {
    			
    		}
		} else if (pos[0] > 0) {
			this.sBuffer.delete(pos[0]-1, pos[0]);
		}		
    }
    
    /**
     * Procédure qui permet de coller le texte dans le buffer, à l'emplacement du curseur.
     * 
     * @param txt : texte à insérer.
     * @param deb : début de l'emplacement.
     */
    public void coller(String txt, int deb) {
    	this.sBuffer.insert(deb, txt);
    }

    /**
     * Procédure qui permet d'insérer du texte dans le buffer.
     * 
     * @param zTxt : texte à insérer.
     */
    public void insererTxt(char caract, int[] pos) {
    	this.sBuffer.insert(pos[0], caract);
    }
    
    
    //--- Getters ---

    /**
     * Fonction qui retourne le texte du buffer.
     * 
     * @return String 
     */
    public String getTxt() {
        return this.sBuffer.toString();
    }
    
    
}