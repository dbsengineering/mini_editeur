/********************************************************************
 * 						Classe EditeurTxt							*
 * 			Client du Design Pattern Command. 						*
 * 			Départ du programme. Permet d'initialiser				*
 * 			les commandes, l'interface utilisateur, 				*
 * 			le receiver et l'observer.								*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 21/11/2017								*
 *		DateModify : ...... 21/11/2017								*
 *******************************************************************/

package client;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cavron Jérémy & Ez Ziraiy Nada
 */
public class EditeurTxt {
	
    /**
     * Prpcédure principale du programme.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	// Creation liste pour l'initialisation des commandes
    	@SuppressWarnings("rawtypes")
		Map<String,command.Command> mapCmds = new HashMap<String,command.Command>();
    	@SuppressWarnings("rawtypes")
		Map<String,memento.OriginatorInter> mapCmdsM = new HashMap<String, memento.OriginatorInter>();
    	
    	// Receiver Initialization
        receiver.MoteurEd receiver = new receiver.MoteurEd();
        
        // Memento Initialization
        memento.CareTaker recorder = new memento.CareTaker(); // Enregistreur

        //--- Commands Initialization & insert in map ---
        
        // Init and insert command Copy
        memento.OriginCopier cmdCopierM = new memento.OriginCopier(receiver, recorder);
        mapCmds.put("Copier", cmdCopierM);
        mapCmdsM.put("Copier", cmdCopierM);
        
        // Init and insert command Cut
        memento.OriginCouper cmdCouperM = new memento.OriginCouper(receiver, recorder);
        mapCmds.put("Couper",cmdCouperM);
        mapCmdsM.put("Couper", cmdCouperM);
        
        // Init and insert command Past
        memento.OriginColler cmdCollerM = new memento.OriginColler(receiver, recorder);
        mapCmds.put("Coller",cmdCollerM);
        mapCmdsM.put("Coller",cmdCollerM);
        
        // Init and insert command InsertTxt
        memento.OriginInsertTxt cmdInsertTxtM = new memento.OriginInsertTxt(receiver, recorder);
        mapCmds.put("Insert",cmdInsertTxtM);
        mapCmdsM.put("Insert",cmdInsertTxtM);
        
        //Init and insert command Selection
        memento.OriginSelectionner cmdSelectM = new memento.OriginSelectionner(receiver, recorder);
        mapCmds.put("Select",cmdSelectM);
        mapCmdsM.put("Select",cmdSelectM);
        
        //Init and insert command Supprime
        memento.OriginSupprime cmdSuppM = new memento.OriginSupprime(receiver, recorder);
        mapCmds.put("Supp",cmdSuppM);
        mapCmdsM.put("Supp",cmdSuppM);
        
        command.Record cmdRec = new command.Record(recorder); mapCmds.put("Rec", cmdRec); //Init Rec
        command.RePlay cmdPlay = new command.RePlay(recorder); mapCmds.put("Play", cmdPlay); // Init Play
        
        // User interface Initialization
        observer.IHMObs ihmObs = new observer.IHMObs(receiver);
        ihmObs.setCmds(mapCmds);
        
        // Init rec
		recorder.setCmds(mapCmdsM);
        
        // Add Observer
        receiver.ajouterObserver(ihmObs);
        
        // Show IHM
        ihmObs.setVisible(true);
    }
}