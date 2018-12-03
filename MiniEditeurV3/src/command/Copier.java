/********************************************************************
 * 						Classe Copier								*
 * 					 Concrete Command								*
 * 					Permet de copier un texte						*
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


import receiver.MoteurEd;

/**
 * @author Cavron Jérémy, Ez Ziraiy Nada
 */
public class Copier implements Command {
	
	//--- Déclaration des propriétées ---
	private MoteurEd receiver; // Le recepteur
	
	/**
	 * Constructeur de la classe.
	 * @param receiver
	 */
	public Copier(MoteurEd receiver){
		this.receiver = receiver;
	}
	
	/**
	 * Procédure de l'execution de la commande.
	 * 
	 */
	@Override
	public void execute() {
		this.receiver.copier();
	}
}