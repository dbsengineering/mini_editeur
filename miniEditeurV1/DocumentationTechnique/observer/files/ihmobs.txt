/********************************************************************
 * 						Classe IHMObs								*
 * 					 	Observer									*
 * 					Permet de notifier les changements de 			*
 * 					l'interface utilisateur							*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 16/10/2017								*
 *******************************************************************/
package observer;

public class IHMObs extends invoker.IHM implements Observer {
	
	// --- Déclaration des propriétées ---
	private static final long serialVersionUID = -4212546953751079865L;
	protected Subject subject;
	
	/**
	 * Constructeur de la classe.
	 * 
	 * @param subject
	 */
	public IHMObs(Subject subject){
		this.subject = subject;
	}
	
	/**
	 * Procédure de notifications. permet de modifier l'interface graphique.
	 */
	public void notifyObs() {
		receiver.MoteurEd receiver = (receiver.MoteurEd) subject;
		super.update(receiver.getSBuffer().getTxt(), receiver.getSelectDeb(), receiver.getSelectLng());
	}
}
