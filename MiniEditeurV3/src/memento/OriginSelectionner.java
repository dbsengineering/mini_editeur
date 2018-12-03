/********************************************************************
 * 						Classe OriginSelectionner					*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande Selectionnerr.						*
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

public class OriginSelectionner extends command.Selectionner implements OriginatorInter {

	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private invoker.IHM ihm;
	private receiver.MoteurEd receiver;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginSelectionner(receiver.MoteurEd receiver, CareTaker recorder, invoker.IHM ihm) {
		super(receiver, ihm);
		this.recorder = recorder;
		this.ihm = ihm;
		this.receiver = receiver;
	}

	/**
	 * Procédure d'execution de la commande.
	 * 
	 * @param pos : int[]
	 */
	@Override
	public void execute() {
		super.execute();
	}
	
	// --- Getters ---

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * [Pas d'enregistrement pour la commande Copier]
	 * 
	 * @return ConcretMCouper : Memento
	 */
	@Override
	public Memento getMemento() {
		int[] pos = {this.receiver.getSelectDeb(), this.receiver.getSelectLng()};
		return new ConcretMSelectionner();
	}
	
	/**
	 * Procédure qui peremt d'executer la commande enregistrée.
	 * [Pas d'enregistrement pour la commande Selectionner]
	 * 
	 * @param m : Mémento.
	 */
	public void execute(Memento m) {
		
	}
}
