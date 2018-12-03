/********************************************************************
 * 						Classe Supprime								*
 * 					 Concrete Command								*
 * 					Permet de supprimer des caractères				*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 16/10/2017								*
 *******************************************************************/
package command;

public class Supprime implements Command<int[]>{
	
	// --- Déclaration des propriétées ---
	receiver.MoteurEd receiver; // Le recepteur
	
	/**
	 * Constructeur de la classe
	 * 
	 * @param receiver : MoteurEd
	 */
	public Supprime(receiver.MoteurEd receiver) {
		this.receiver = receiver;
	}
	
	/**
	 *  Procédure de l'execution de la commande.
	 *  
	 *  @param pos : int[] . debut / longueur
	 */
	@Override
	public void execute(int[] pos) {
		this.receiver.supprimer(pos);
	}
}
