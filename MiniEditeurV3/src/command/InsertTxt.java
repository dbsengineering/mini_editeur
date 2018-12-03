/********************************************************************
 * 						Classe insertTxt							*
 * 					 	Concrete Command							*
 * 			Permet d'insérer le texte slélectionné					*
 * 			dans le buffer.											*
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

public class InsertTxt implements Command {

	// --- Déclaration des propriétées ---
	private MoteurEd receiver; // Le recepteur
	private invoker.IHM ihm;

	/**
	 * Constructeur de la classe
	 * 
	 * @param receiver
	 */
	public InsertTxt(MoteurEd receiver, invoker.IHM ihm) {
		this.receiver = receiver;
		this.ihm = ihm;
	}

	/**
	 * Procédure de l'execution de la commande
	 */
	@Override
	public void execute() {
		this.receiver.insertTxt(this.ihm.getLastChar());
	}

}
