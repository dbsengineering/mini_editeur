/********************************************************************
 * 						Classe OriginCopier							*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande Copier.								*
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

public class OriginCopier extends command.Copier implements OriginatorInter {
	
	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private receiver.MoteurEd receiver;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginCopier(receiver.MoteurEd receiver, CareTaker recorder) {
		super(receiver);
		this.recorder = recorder;
		this.receiver = receiver;
	}
	
	// --- Getters ---

	/**
	 * Procédure d'execution de la commande.
	 */
	@Override
	public void execute() {
		if (this.receiver.getSelectLng() > 0) {
			super.execute();
		}
	}

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * [Pas d'enregistrement pour la commande Copier]
	 * 
	 * @return ConcretMCopier : Memento
	 */
	@Override
	public Memento getMemento() {
		int[] pos = {this.receiver.getSelectDeb(), this.receiver.getSelectLng()};
		return new ConcretMCopier();
	}
	
	/**
	 * Procédure qui peremt d'executer la commande enregistrée.
	 * [Pas d'enregistrement pour la commande Copier]
	 * 
	 * @param m : Mémento.
	 */
	public void execute(Memento m) {
	}
}
