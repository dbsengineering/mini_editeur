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

public class InsertTxt implements Command<Character> {

	// --- Déclaration des propriétées ---
	MoteurEd receiver; // Le recepteur

	/**
	 * Constructeur de la classe
	 * 
	 * @param receiver
	 */
	public InsertTxt(MoteurEd receiver) {
		this.receiver = receiver;
	}

	/**
	 * Proc�dure de l'execution de la commande
	 */
	@Override
	public void execute(Character caractere) {
		this.receiver.insertTxt(caractere);
	}

}
