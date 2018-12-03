/********************************************************************
 * 						Classe Coller								*
 * 					Permet de coller un élément texte				*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 15/10/2017								*
 *******************************************************************/
package command;


/**
 * 
 */
public class Coller implements Command<Integer> {

	// --- Déclaration des propriétées ---
	private receiver.MoteurEd receiver; // Le recepteur

	/**
	 * Constructeur de la classe
	 * 
	 * @param receiver : MoteurEd
	 */
	public Coller(receiver.MoteurEd receiver) {
		this.receiver = receiver;
	}

	/**
	 * Procédure de l'execution de la commande
	 * 
	 * @param deb : Integer. début de l'insertion.
	 */
	@Override
	public void execute(Integer deb) {
		this.receiver.coller(deb);
	}
}