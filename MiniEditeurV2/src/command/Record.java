/********************************************************************
 * 						Classe Rec									*
 * 					 Concrete Command								*
 * 					Permet de lancer ou d'arrêter					*
 * 				une séquence d'enregistrement sur les actions		*
 * 				que l'utilisateur à faites sur l'interface.			*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 21/11/2017								*
 *		DateModify : ...... 21/11/2017								*
 *******************************************************************/
package command;

public class Record implements Command<Boolean>{
	
	//--- Déclaration des propriétées ---
	private memento.CareTaker recorder;// L'enregistreur de commandes
	
	/**
	 * Constructeur de la classe Rec.
	 * 
	 * @param receiver : Moteur de l'éditeur. MoteurEd
	 */
	public Record(memento.CareTaker recorder) {
		this.recorder = recorder;
	}
	
	/**
	 * Procédure de l'execution de la commande.
	 * 
	 * @param switcher : est un interrupteur qui permet de
	 * savoir si l'enregistrement est démarré ou stoppé.
	 */
	@Override
	public void execute(Boolean switcher) {
		//Si le "switcher" est enclenché
		//Alors on enregistre.
		//Sinon on arrête l'enregistrement.
		if(switcher) {
			//Enregistre
			this.recorder.recStart();
		}else {
			//Arrêter
			this.recorder.recStop();
		}
	}

}
