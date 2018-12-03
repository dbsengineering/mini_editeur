/********************************************************************
 * 						Classe CareTaker							*
 * 					Objet qui sait pourquoi et quand				*
 * 					l'Originateur a besoin de sauvegarder			*
 * 					ou d'être restoré.								*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 21/11/2017								*
 *		DateModify : ...... 21/11/2017								*
 *******************************************************************/
package memento;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Gardien / Enregistreur
 */
public class CareTaker implements CaretakerInter {
	
	//--- Déclaration des propriétées ---
	@SuppressWarnings("rawtypes")
	private Queue<Memento> mementos;
	@SuppressWarnings({ "rawtypes" })
	private Map<String, OriginatorInter> mapCmds;
	private boolean etatRec;

	/**
	 * Constructeur
	 */
	@SuppressWarnings("rawtypes")
	public CareTaker() {
		this.mementos = new LinkedList<Memento>();
		this.mapCmds = new HashMap<String, OriginatorInter>();
	}

	/**
	 * Procédure qui enregistre une séquence de commandes.
	 * 
	 * @param c : la commande à enregistrer.
	 */
	public void recCommand(@SuppressWarnings("rawtypes") OriginatorInter o) {
		if (this.etatRec) {
			this.mementos.add(o.getMemento());
		}
	}

	/**
	 * Procédure qui rejoue un enregistrement.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void rePlay() {
		if (!this.etatRec) {
			Iterator<Memento> itM = this.mementos.iterator();
			while(itM.hasNext()) {
				Memento m = itM.next();
				mapCmds.get(m.getType()).setMemento(m);
			}
		}
	}

	/**
	 * Procédure qui démarre un enregistrement.
	 */
	public void recStart() {
		this.mementos.clear();
		this.etatRec = true;
	}

	/**
	 * Procédure qui arrête un enregistrement.
	 */
	public void recStop() {
		this.etatRec = false;
	}

	/**
     * Initialisation des commandes.
     * 
     * @param mapCmds : map de commandes . <String, Originator>
     */
    public void setCmds(@SuppressWarnings("rawtypes") Map<String, OriginatorInter> mapCmds){
    	this.mapCmds = mapCmds;
    }
}
