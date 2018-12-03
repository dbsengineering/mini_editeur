/********************************************************************
 * 						Interface Originator						*
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

public interface OriginatorInter<T>{
	//--- Opérations ---
	public void execute(T type);
	public Memento<T> getMemento();
	public void setMemento(Memento<T> memento);
}
