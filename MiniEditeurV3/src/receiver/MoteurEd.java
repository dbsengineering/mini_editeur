/********************************************************************
 * 						Classe MoteurEd								*
 * 					Moteur de l'éditeur								*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 21/11/2017								*
 *******************************************************************/
package receiver;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */
public class MoteurEd extends observer.Subject implements MoteurEdInter {

	// --- Déclaration des proprétées ---
	private Select select;
	private Buffer buff;
	private PressPapier pp;

	/**
	 * Constructeur de la classe.
	 */
	public MoteurEd() {
		observers = new ArrayList<observer.Observer>();
		pp = new PressPapier();
		select = new Select();
		buff = new Buffer();
	}
	
	//--- Fonctions du moteur ---

	/**
	 * Procédure qui permet de couper un texte.
	 */
	public void couper() {
		if (select.getLng() > 0) {
			pp.setContenu(getSelectTxt());
			this.copier();
			this.supprimer();
			select.setLng(0);
			notifyObservers();
		}
	}

	/**
	 * Procédure qui permet de copier le texte sélectionné dans le presse papier.
	 * 
	 */
	public void copier() {
		if (select.getLng() > 0) {
			pp.setContenu(getSelectTxt());
		}
	}

	/**
	 * Procédure qui permet de supprimer le texte sélectionné ou les caractères derrière le curseur.
	 * 
	 */
	public void supprimer() {
		int[] pos = { select.getDebut(), select.getLng() };
		this.buff.supprimer(pos);
		//si on a selectionné
		if (pos[1] > 0) {
			select.setLng(0);
		} 
		//si il n'y a pas de selection et si il se n'est pas le premier caractere
		else if (pos[0] > 0) {
			select.setDebut(pos[0] - 1);
		}
		notifyObservers();
	}

	/**
	 * Procédure qui permet de coller le texte
	 * 
	 */
	public void coller() {
		int i = select.getDebut();
		if (!pp.getContenu().equals("")) {
			select.setDebut(i);
			if (select.getLng() != 0) {
				supprimer();
			}
			this.buff.coller(pp.getContenu(), i);
			select.setDebut(i + pp.getContenu().length());
			notifyObservers();
		}
	}

	/**
	 * Procédure qui permet d'ajouter du texte dans le buffer.
	 * 
	 * @param caractere : est le caractère à ajouter.
	 */
	public void insertTxt(char caractere) {
		int[] pos = { select.getDebut(), select.getLng() };
		if (select.getLng() != 0) {
			supprimer();
			select.setLng(0);
		}
		select.setDebut(pos[0] + 1);
		this.buff.insererTxt(caractere, pos);
		notifyObservers();
	}
	
	/**
	 * Fonction qui retourne le texte du buffer suivant la sélection.
	 * 
	 * @return texte : texte du buffer.
	 */
	public String getSelectTxt() {
		int deb = select.getDebut();
		int lng = select.getLng();
		if (select.getLng() > 0) {
			return this.buff.getTxt().substring(deb, deb + lng);
		} else {
			return "";
		}
	}

	//--- Getters ---
	/**
	 * Fonction qui retourne le buffer qui contient le texte.
	 * 
	 * @return buffer : le buffer.
	 */
	public Buffer getSBuffer() {
		return this.buff;
	}
	
	/**
	 * Fonction qui retourne le press Papier.
	 * 
	 * @return pp : PressPapier.
	 */
	public PressPapier getPP() {
		return this.pp;
	}
	
	/**
	 * Fonction qui retourne le début de la sélection.
	 * 
	 * @return int : début de sélection.
	 */
	public int getSelectDeb() {
		return select.getDebut();
	}

	/**
	 * Fonction qui retourne la longueur de la sélection.
	 * 
	 * @return int : longueur de la sélection.
	 */
	public int getSelectLng() {
		return select.getLng();
	}
	
	//--- Setters ---
	/**
	 * Procédure qui permet de modifier la sélection du texte.
	 * 
	 * @param pos : tableau de la position du curseur. Début du curseur / longueur de la sélection.
	 */
	public void setSelectTxt(int[] pos) {
		select.setDebut(pos[0]);
		select.setLng(pos[1]);
	}
	
	//--- Méthodes des observeurs ---

	/**
	 * Procédure qui permet de lister les observeurs.
	 */
	@Override
	public void notifyObservers() {
		for (Iterator<observer.Observer> it = observers.iterator(); it.hasNext();) {
			observer.Observer o = it.next();
			o.notifyObs();
		}
	}

	/**
	 * Procédure d'ajout d'un observeur.
	 * 
	 * @param o : Observeur.
	 */
	@Override
	public void ajouterObserver(observer.Observer o) {
		observers.add(o);
	}

	/**
	 * Procédure pour enlever un observeur.
	 * 
	 * @param o : Observeur.
	 */
	@Override
	public void enleverObserver(observer.Observer o) {
		observers.remove(o);
	}
}