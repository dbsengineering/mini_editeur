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
 *		DateStart : ....... 06/12/2017								*
 *		DateModify : ...... 06/12/2017								*
 *******************************************************************/
package memento;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Gardien / Enregistreur
 */
public class CareTaker implements CaretakerInter {

	// --- Déclaration des propriétées ---
	private Stack<Memento> pileFait; // Pile 
	private Stack<Memento> pileARefaire; // Pile
	private Map<String, OriginatorInter> mapCmds;
	private receiver.MoteurEd receiver;
	private int[] pos; // Position de la sélection. Début / Longueur

	/**
	 * Constructeur
	 */
	public CareTaker(receiver.MoteurEd receiver) {
		this.pileFait = new Stack<Memento>();
		this.pileARefaire = new Stack<Memento>();
		this.mapCmds = new HashMap<String, OriginatorInter>();
		this.receiver = receiver;
		this.pos = new int[2];
	}

	/**
	 * Procédure qui enregistre une séquence de commandes.
	 * 
	 * @param o : la commande à enregistrer.
	 */
	public void recCommand(OriginatorInter o) {
		this.pileARefaire.clear();
		Memento m = o.getMemento();
		this.pileFait.push(m);
	}

	/**
	 * Procédure qui permet de défaire la pile.
	 */
	public void undo() {
		if (!this.pileFait.empty()) {
			Memento m = pileFait.pop();
			this.pileARefaire.push(m);
			State state = m.getState();
			this.pos[0] = state.getSelectDeb();
			
			switch(m.getType()) {
			case "Couper":
				this.pos[1] = 0;
				
				this.receiver.setSelectTxt(pos);
				for (int i = 0; i < state.getSelectTxt().length(); i++) {
					this.receiver.insertTxt(state.getSelectTxt().charAt(i));
				}
				break;
			case "Coller":
				this.pos[1] = state.getPP().getContenu().length();
				
				this.receiver.setSelectTxt(this.pos);
				this.receiver.supprimer();
				for (int i = 0; i < state.getSelectTxt().length(); i++) {
					this.receiver.insertTxt(state.getSelectTxt().charAt(i));
				}
				break;
			case "Insert":
				this.pos[1] = 1;
				
				this.receiver.setSelectTxt(this.pos);
				this.receiver.supprimer();
				for (int i = 0; i < state.getSelectTxt().length(); i++) {
					this.receiver.insertTxt(state.getSelectTxt().charAt(i));
				}

				break;
			case "Supp":
				if (state.getSelectLng() == 0) {
					this.pos[0] = this.pos[0]-1;
					this.pos[1] = 0;
					
					this.receiver.setSelectTxt(this.pos);
					this.receiver.insertTxt(state.getCaract());
				} else {
					this.pos[1] = 0;
					
					this.receiver.setSelectTxt(this.pos);
					for (int i = 0; i < state.getSelectTxt().length(); i++) {
						this.receiver.insertTxt(state.getSelectTxt().charAt(i));
					}
				}
				break;
			}
		}
	}

	/**
	 * Procédure refaire
	 */
	public void redo() {
		if (!this.pileARefaire.empty()) {
			Memento m = pileARefaire.pop();
			this.pileFait.push(m);
			mapCmds.get(m.getType()).execute(m);
		}
	}

	/**
	 * Initialisation des commandes.
	 * 
	 * @param mapCmds
	 *            : map de commandes . <String, Originator>
	 */
	public void setCmds(Map<String, OriginatorInter> mapCmds) {
		this.mapCmds = mapCmds;
	}
}
