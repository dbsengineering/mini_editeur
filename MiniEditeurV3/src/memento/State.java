package memento;

public class State {
	
	// --- Déclaration des propriétées ---
	private int deb; // Début de sélection
	private int lng; // Longueur de la sélection
	private String txtSelect;
	private receiver.PressPapier pp; // Press Papier
	private char cararactere;

	public State() {
		this.deb = 0;
		this.lng = 0;
		this.txtSelect = "";
		this.pp = new receiver.PressPapier();
		this.cararactere = 'x';
	}
	
	public State(State state) {
		this.deb = state.deb;
		this.lng = state.lng;
		this.txtSelect = state.txtSelect;
		this.pp = state.pp;
		this.cararactere = state.cararactere;
	}

	public int getSelectDeb() {
		return this.deb;
	}

	public void setSelectDeb(int d) {
		this.deb = d;
	}

	public int getSelectLng() {
		return this.lng;
	}

	public void setSelectLng(int l) {
		this.lng = l;
	}

	public String getSelectTxt() {
		return this.txtSelect;
	}

	public void setTxtSelect(String t) {
		this.txtSelect = t;
	}

	public receiver.PressPapier getPP() {
		return this.pp;
	}

	public void setPP(receiver.PressPapier pp) {
		this.pp = pp;
	}

	public char getCaract() {
		return this.cararactere;
	}

	public void setCaract(char c) {
		this.cararactere = c;
	}
}
