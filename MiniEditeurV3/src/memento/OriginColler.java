/********************************************************************
 * 						Classe OriginColler							*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande Coller.								*
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

public class OriginColler extends command.Coller implements OriginatorInter {

	// --- Déclaration des propriétées ---
	private receiver.MoteurEd receiver;
	private CareTaker recorder;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginColler(receiver.MoteurEd receiver, CareTaker recorder) {
		super(receiver);
		this.receiver = receiver;
		this.recorder = recorder;
	}

	/**
	 * Procédure d'execution de la commande.
	 * 
	 * @param deb : Integer
	 */
	@Override
	public void execute() {
		if (this.receiver.getPP().getContenu().length() > 0) {
			this.recorder.recCommand(this);
		}
		super.execute();
	}
	
	// --- Getters ---

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * 
	 * @return ConcretMColler : Memento
	 */
	@Override
	public Memento getMemento() {
		ConcretMColler m = new ConcretMColler();
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
		State state = ((ConcretMColler) m).getState();
		int[] pos = {state.getSelectDeb(), state.getSelectLng()};
		this.receiver.setSelectTxt(pos);
		super.execute();
	}
}
