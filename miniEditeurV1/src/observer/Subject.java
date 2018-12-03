/********************************************************************
 * 						Classe Subject								*
 * 					Mets à disposition les opérations de			*
 * 					notifications.									*
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

import java.util.Collection;

public abstract class Subject {
	
	//--- Déclaration des propriétées ---
	protected Collection<Observer> observers;
	
	/**
	 * Notifie tous les <i>Observers</i> enregistrés.
	 */
	public abstract void  ();

	/**
	 * Inscrit un nouvel <i>Observer</i>.
	 * 
	 * @param o : l'observer à enregistrer
	 */
	public abstract void ajouterObserver(Observer o);

	/**
	 * Désinscrit un <i>Observer</i> précédemment inscrit.
	 * 
	 * @param o : l'observer à désinscrire ; si o n'est pas dans observers,
	 *            cette méthode ne fait rien.
	 */
	public abstract void enleverObserver(Observer o);
}
