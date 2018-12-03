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


/**
 * @author Cavron Jérémy, Ez Ziraiy Nada
 */
public class Copier implements Command<Integer> {
	
	//--- Déclaration des propriétées ---
	receiver.MoteurEd receiver; // Le recepteur
	
	/**
	 * Constructeur de la classe
	 * @param receiver : MoteurEd
	 */
	public Copier(receiver.MoteurEd receiver){
		this.receiver = receiver;
	}
	
	/**
	 * Procédure de l'execution de la commande.
	 * 
	 * @param lng : Integer . longueur de la sélection.
	 */
	@Override
	public void execute(Integer lng) {
		this.receiver.copier(lng);
	}
}