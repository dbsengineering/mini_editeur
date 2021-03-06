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

import receiver.MoteurEd;

/**
 * 
 */
public class Coller implements Command {

	// --- Déclaration des propriétées ---
	private MoteurEd receiver; // Le recepteur

	/**
	 * Constructeur de la classe
	 * 
	 * @param receiver
	 */
	public Coller(MoteurEd receiver) {
		this.receiver = receiver;
	}

	/**
	 * Procédure de l'execution de la commande
	 * 
	 */
	@Override
	public void execute() {
		this.receiver.coller();
	}

}