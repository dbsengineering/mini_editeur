/********************************************************************
 * 						Interface MoteurEdInter						*
 * 																	*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 15/10/2017								*
 *******************************************************************/
package receiver;


/**
 * 
 */
public interface MoteurEdInter {

	// --- Opérations ---
    public void couper(int[] pos);
    public void copier(int lng);
    public void coller(int deb);
    public void insertTxt(char caract);
    public void setSelectTxt(int[] pos);
    public void supprimer(int[] pos);
    public Buffer getSBuffer();
    public int getSelectDeb();
    public int getSelectLng();
}