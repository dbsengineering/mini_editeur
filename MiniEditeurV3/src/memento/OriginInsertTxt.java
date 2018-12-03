/********************************************************************
 * 						Classe OriginInsertTxt						*
 * 					Permet de savoir comment sauvegarder			*
 * 					la commande InsertTxt.							*
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

public class OriginInsertTxt extends command.InsertTxt implements OriginatorInter {

	// --- Déclaration des propriétées ---
	private CareTaker recorder;
	private receiver.MoteurEd receiver;
	private invoker.IHM ihm;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param receiver : MoteurEd
	 * @param recorder : CareTaker
	 */
	public OriginInsertTxt(receiver.MoteurEd receiver, CareTaker recorder, invoker.IHM ihm) {
		super(receiver, ihm);
		this.receiver = receiver;
		this.recorder = recorder;
		this.ihm = ihm;
	}

	/**
	 * Procédure d'execution de la commande.
	 */
	@Override
	public void execute() {
		this.recorder.recCommand(this);
		super.execute();
	}
	
	// --- Getters ---

	/**
	 * Fonction qui retourne le mémento de la commande.
	 * 
	 * @return ConcretMInsert : Memento
	 */
	@Override
	public Memento getMemento() {
		ConcretMInsertTxt m = new ConcretMInsertTxt();
		State state = m.getState();
		state.setTxtSelect(this.receiver.getSelectTxt());
		state.setSelectDeb(this.receiver.getSelectDeb());
		state.setSelectLng(this.receiver.getSelectLng());
		state.setCaract(ihm.getLastChar());
		m.setState(state);
		return m;
	}
	
	public void execute(Memento m) {
		State state = ((ConcretMInsertTxt) m).getState();
		int[] pos = {state.getSelectDeb(), state.getSelectLng()};
		this.receiver.setSelectTxt(pos);
		this.receiver.insertTxt(state.getCaract());
	}
}
