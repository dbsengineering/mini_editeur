/********************************************************************
 * 						Classe Selectionner							*
 * 					 Concrete Command								*
 * 					Permet de selectionner des caractères			*
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

/**
 * 
 */
public class Selectionner implements Command<int[]> {
	
	//--- Déclaration des propriétées ---
	receiver.MoteurEd receiver; // Le recepteur
	
	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 */
	public Selectionner(receiver.MoteurEd receiver){
		this.receiver = receiver;
	}
	
	/**
	 * Procédure de l'execution de la commande
	 * 
	 * @param pos : int[] . début sélection / Longueur sélection
	 */
	@Override
	public void execute(int[] pos) {
		this.receiver.setSelectTxt(pos);
	}
}