/********************************************************************
 * 						Interface Command							*
 * 																	*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 16/10/2017								*
 *******************************************************************/
package command;

/**
 * @author Cavron Jérémy, Ez Ziraiy Nada
 */
public interface Command<V> {
	// --- Opérations ---

	/**
	 * Procédure d'execution.
	 * 
	 * @param args : arguments passés dans l'execution.
	 */
    public void execute(V args);
}