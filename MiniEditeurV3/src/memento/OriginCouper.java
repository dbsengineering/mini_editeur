/********************************************************************
 * 						Classe OriginCouper							*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande Couper.								*
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

public class OriginCouper extends command.Couper implements OriginatorInter {

	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private receiver.MoteurEd receiver;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginCouper(receiver.MoteurEd receiver, CareTaker recorder) {
		super(receiver);
		this.recorder = recorder;
		this.receiver = receiver;
	}

	/**
	 * Procédure d'execution de la commande.
	 * 
	 */
	@Override
	public void execute() {
		if (this.receiver.getSelectLng() > 0) {
			this.recorder.recCommand(this);
		}
		super.execute();
	}
	
	// --- Getters

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * 
	 * @return ConcretMCouper : Memento
	 */
	@Override
	public Memento getMemento() {
		ConcretMCouper m = new ConcretMCouper();
		State state = m.getState();
		state.setTxtSelect(this.receiver.getSelectTxt());
		state.setSelectDeb(this.receiver.getSelectDeb());
		state.setSelectLng(this.receiver.getSelectLng());
		state.setPP(this.receiver.getPP());
		m.setState(state);
		return m;
	}
	
	/**
	 * Procédure qui peremt d'executer la commande enregistrée.
	 * 
	 * @param m : Mémento.
	 */
	public void execute(Memento m) {
		State state = ((ConcretMCouper) m).getState();
		int[] pos = {state.getSelectDeb(), state.getSelectLng()};
		this.receiver.setSelectTxt(pos);
		this.receiver.supprimer();
	}
}
