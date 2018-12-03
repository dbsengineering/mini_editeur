/********************************************************************
 * 						Classe insertTxt							*
 * 					 	Concrete Command							*
 * 			Permet d'insérer du texte à la position du				*
 * 			curseur.												*
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

public class InsertTxt implements Command<Character> {

	// --- Déclaration des propriétées ---
	receiver.MoteurEd receiver; // Le recepteur

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 */
	public InsertTxt(receiver.MoteurEd receiver) {
		this.receiver = receiver;
	}

	/**
	 * Procédure de l'execution de la commande.
	 * 
	 * @param caractere : Character . Caractère à insérer.
	 */
	@Override
	public void execute(Character caractere) {
		this.receiver.insertTxt(caractere);
	}
}
