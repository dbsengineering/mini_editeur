/********************************************************************
 * 						Classe Selectionner							*
 * 					 Concrete Command								*
 * 					Permet de selectionner un texte					*
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
 * 
 */
public class Selectionner implements Command {
	
	//--- Déclaration des propriétées ---
	private MoteurEd receiver; // Le recepteur
	private invoker.IHM ihm;
	
	/**
	 * Constructeur de la classe
	 * @param receiver
	 */
	public Selectionner(MoteurEd receiver, invoker.IHM ihm){
		this.receiver = receiver;
		this.ihm = ihm;
	}
	
	/**
	 * Procédure de l'execution de la commande
	 */
	@Override
	public void execute() {
		int[] pos = {ihm.getDebSelect(), ihm.getLngSelect()};
		this.receiver.setSelectTxt(pos);
	}
}