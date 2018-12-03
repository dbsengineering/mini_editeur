/********************************************************************
 * 						Classe IHMObs								*
 * 					Permet de renvoyer des notifications.			*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 21/11/2017								*
 *		DateModify : ...... 21/11/2017								*
 *******************************************************************/
package observer;

public class IHMObs extends invoker.IHM implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4212546953751079865L;
	protected Subject subject;
	
	/**
	 * Constructeur de la classe.
	 * @param subject
	 */
	public IHMObs(Subject subject){
		this.subject = subject;
	}
	
	/**
	 * Procédure de notifications. permet de modifier l'interface graphique
	 */
	public void notifyObs() {
		receiver.MoteurEd receiver = (receiver.MoteurEd) subject;
		super.update(receiver.getSBuffer().getTxt(), receiver.getSelectDeb(), receiver.getSelectLng());
	}
	
}
