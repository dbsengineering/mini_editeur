/********************************************************************
 * 						Classe Couper								*
 * 					permet de couper un texte						*
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
public class Couper implements Command<int[]> {

	// --- Déclaration des propriétées ---
	receiver.MoteurEd receiver; // Le recepteur

	/**
	 * Constructeur de la classe
	 * 
	 * @param receiver : MoteurEd
	 */
	public Couper(receiver.MoteurEd receiver) {
		this.receiver = receiver;
	}

	/**
	 * Procédure de l'execution de la commande.
	 * 
	 * @param pos : int[] : début /Longueur.
	 */
	@Override
	public void execute(int[] pos) {
		this.receiver.couper(pos);
	}
}