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
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 15/10/2017								*
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	//Creation liste pour l'initialisaiton des commandes
    	@SuppressWarnings("rawtypes")
		Map<String,command.Command> mapCmds = new HashMap<String,command.Command>();
    	
    	//Receiver Initialization
        receiver.MoteurEd receiver = new receiver.MoteurEd();

        //Commands Initialization & insert in list
        command.Copier cmdCopier = new command.Copier(receiver); mapCmds.put("Copier",cmdCopier); // Init and insert liste copier
        command.Couper cmdCouper = new command.Couper(receiver); mapCmds.put("Couper",cmdCouper); // Init couper
        command.Coller cmdColler = new command.Coller(receiver); mapCmds.put("Coller",cmdColler); // Init coller
        command.InsertTxt cmdInsertTxt = new command.InsertTxt(receiver); mapCmds.put("Insert",cmdInsertTxt); // Init insertTxt
        command.Selectionner cmdSelect = new command.Selectionner(receiver); mapCmds.put("Select",cmdSelect); //Init Selection
        command.Supprime cmdSupp = new command.Supprime(receiver); mapCmds.put("Supp",cmdSupp); //Init Supprime
        
        // User interface Initialization
        observer.IHMObs ihmObs = new observer.IHMObs(receiver);
        ihmObs.setCmds(mapCmds);
        
        //Add Observer
        receiver.ajouterObserver(ihmObs);
        
        // Show IHM
        ihmObs.setVisible(true);
    }
}
