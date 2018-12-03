/********************************************************************
 * 						Classe OriginSupprime						*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande Supprime.							*
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

public class OriginSupprime extends command.Supprime implements OriginatorInter {

	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private receiver.MoteurEd receiver;
	
	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginSupprime(receiver.MoteurEd receiver, CareTaker recorder) {
		super(receiver);
		this.recorder = recorder;
		this.receiver = receiver;
	}

	/**
	 * Procédure d'execution de la commande.
	 */
	@Override
	public void execute() {
		if (this.receiver.getSelectDeb() > 0 || this.receiver.getSelectLng() > 0) { 
			this.recorder.recCommand(this);
		}
		super.execute();
	}
	
	// --- Getters ---

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * 
	 * @return ConcretMCouper : Memento
	 */
	@Override
	public Memento getMemento() {
		ConcretMSupprime m = new ConcretMSupprime();
		State state = m.getState();
		if (this.receiver.getSelectLng() > 0) {
			
			state.setTxtSelect(this.receiver.getSelectTxt());
		} else {
			int i = this.receiver.getSelectDeb();
			if (i > 0) {
				state.setCaract(this.receiver.getSBuffer().getTxt().charAt(i - 1));
			}
		}
		state.setSelectDeb(this.receiver.getSelectDeb());
		state.setSelectLng(this.receiver.getSelectLng());
		m.setState(state);
		return m;
	}
	
	/**
	 * Procédure qui peremt d'executer la commande enregistrée.
	 * 
	 * @param m : Mémento.
	 */
	public void execute(Memento m) {
		State state = ((ConcretMSupprime) m).getState();
		int[] pos = {state.getSelectDeb(), state.getSelectLng()};
		this.receiver.setSelectTxt(pos);
		this.receiver.supprimer();
	}
}
