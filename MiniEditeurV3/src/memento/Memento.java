/********************************************************************
 * 						Interface Memento							*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 06/12/2017								*
 *		DateModify : ...... 06/12/2017								*
 *******************************************************************/
package memento;

/**
 * @author Cavron Jérémy & Ez Ziraiy Nada
 * @version 3.0
 */
public interface Memento {
	public String getType();
	public State getState();
	public void setState(State state);
}
