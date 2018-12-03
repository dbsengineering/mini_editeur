/********************************************************************
 * 						Interface CareTaker							*
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

/**
 * Gardien / Enregistreur interface
 */
public interface CaretakerInter {
	// --- Opérations ---
	public void undo();
	public void redo();
	public void recCommand(OriginatorInter o);
}
