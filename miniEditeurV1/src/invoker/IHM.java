/********************************************************************
 * 						Classe IHM									*
 * 				Interface graphique du programme					*
 *																	*
 *		School : .......... Istic									*
 *		Formation : ....... Master 1 MIAGE							*
 *		Lecture : ......... ACO										*
 *		Group : ........... 1a										*
 *		Authors : ......... Cavron Jérémy, Ez Ziraiy Nada			*
 *		DateStart : ....... 12/10/2017								*
 *		DateModify : ...... 21/11/2017								*
 *******************************************************************/
package invoker;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

/**
 * @author Cavron Jérémy & Ez Ziraiy Nada
 */
public class IHM extends javax.swing.JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 261566542162805098L;
	/**
     * Constructeur de la classe.
     */
    public IHM() {
        initComponents(); // Initialisation des composants
    }
    
    /**
     * Procédure d'initialisation des composants.
     */
    private void initComponents() {

    	//--- Initialisation des composants graphiques ---
        pnlText = new javax.swing.JPanel();
        pnlTool = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEdit = new javax.swing.JTextArea();
        pnlStatut = new javax.swing.JPanel();
        lblStatut = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuEdit = new javax.swing.JMenu();
        btnCopy = new javax.swing.JMenuItem();
        btnBisCopy = new javax.swing.JButton();
        btnCut = new javax.swing.JMenuItem();
        btnBisCut = new javax.swing.JButton();
        btnPast = new javax.swing.JMenuItem();
        btnBisPast = new javax.swing.JButton();
        toolbar = new javax.swing.JToolBar();
        
        // Chargement du Fichier de configuration de l'interface
        try {
        	properties.load(new FileInputStream("configuration.properties"));
        }catch(IOException e) {
        	System.out.println("Problème de fichier de configuration");
        	JOptionPane.showMessageDialog(null, "Problème de fichier de configuration. Le fichier \"configuration.properties\" doit"
        			+ " se trouver au même endroit que l'exécutable. ");
        	System.exit(0);
        }
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(properties.getProperty("title"));
        
        //Chargement de l'icone de l'application
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            ImageIcon programIcon = new ImageIcon(cl.getResource("res/word.png"));
            setIconImage(programIcon.getImage());
         } catch (Exception whoJackedMyIcon) {
            System.out.println("Ne peut pas charger l'icon du programme.");
         }
        setBackground(new java.awt.Color(Integer.parseInt(properties.getProperty("colorFrame"), 16)));

        pnlText.setBackground(new java.awt.Color(Integer.parseInt(properties.getProperty("colorFrame"), 16)));

        txtEdit.setColumns(20);
        txtEdit.setRows(5);
        jScrollPane1.setViewportView(txtEdit);
        
        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        javax.swing.GroupLayout pnlTextLayout = new javax.swing.GroupLayout(pnlText);
        pnlText.setLayout(pnlTextLayout);
        pnlTextLayout.setHorizontalGroup(
            pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlTextLayout.setVerticalGroup(
            pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        
        // pnl toolbar
        javax.swing.GroupLayout jPnlToolLt = new javax.swing.GroupLayout(pnlTool);
        pnlTool.setLayout(jPnlToolLt);
        jPnlToolLt.setHorizontalGroup(
        		jPnlToolLt.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlToolLt.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 106, Short.MAX_VALUE))
        );
        jPnlToolLt.setVerticalGroup(
            jPnlToolLt.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlStatut.setBackground(new java.awt.Color(102, 102, 102));
        lblStatut.setForeground(new java.awt.Color(255, 255, 255));
        lblStatut.setText("Ligne : 1, Colonne : 1");

        javax.swing.GroupLayout pnlStatutLayout = new javax.swing.GroupLayout(pnlStatut);
        pnlStatut.setLayout(pnlStatutLayout);
        pnlStatutLayout.setHorizontalGroup(
            pnlStatutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
        );
        pnlStatutLayout.setVerticalGroup(
            pnlStatutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuFile.setText("Fichier");
        menuBar.add(menuFile);
        menuEdit.setText("Editer");
        
        //bouton copier dans le menu
        btnCopy.setText("Copier");
        menuEdit.add(btnCopy);
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        //bouton couper dans le menu
        btnCut.setText("Couper");
        menuEdit.add(btnCut);
        btnCut.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		cutActionPerformed(evt);
        	}
        });
        //Bouton coller dans le menu
        btnPast.setText("Coller");
        menuEdit.add(btnPast);
        btnPast.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		pastActionPerformed(evt);
        	}
        });

        menuBar.add(menuEdit);
        setJMenuBar(menuBar);
        
        //Bouton Copier dans Toolbar
        try {
        	java.awt.Image imgCopy = javax.imageio.ImageIO.read(getClass().getResource("/res/copy.png"));
            this.btnBisCopy.setIcon(new javax.swing.ImageIcon(imgCopy));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        btnBisCopy.setToolTipText("Copier");
        btnBisCopy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBisCopy.setFocusable(false);
        btnBisCopy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBisCopy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBisCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        
        // Bouton couper de la toolbar
        try {
        	java.awt.Image imgCut = javax.imageio.ImageIO.read(getClass().getResource("/res/cut.png"));
            this.btnBisCut.setIcon(new javax.swing.ImageIcon(imgCut));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        btnBisCut.setToolTipText("Couper");
        btnBisCut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBisCut.setFocusable(false);
        btnBisCut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBisCut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBisCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });
        
        // Bouton coller de la toolbar
        try {
        	java.awt.Image imgPast = javax.imageio.ImageIO.read(getClass().getResource("/res/past.png"));
            this.btnBisPast.setIcon(new javax.swing.ImageIcon(imgPast));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        btnBisPast.setToolTipText("Coller");
        btnBisPast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBisPast.setFocusable(false);
        btnBisPast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBisPast.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBisPast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastActionPerformed(evt);
            }
        });
        
        //Ajout des bouton à la toolbar
        toolbar.add(btnBisCopy); // Ajout du bouton Copier dans la toolbar
        toolbar.add(btnBisCut); // Ajout du bouton Couper dans la toolbar
        toolbar.add(btnBisPast); // Ajout du bouton Coller dans la toolbar
        
        //Modification de la couleur de l'éditeur
        txtEdit.setBackground(new java.awt.Color(Integer.parseInt(properties.getProperty("colorBackText"), 16)));
        txtEdit.setForeground(new java.awt.Color(Integer.parseInt(properties.getProperty("colorText"), 16)));
        txtEdit.setCaretColor(new java.awt.Color(Integer.parseInt(properties.getProperty("colorCursor"), 16)));

        // Sélection dans le textarea
        //Evénnement sur ajout de caractère également.
        txtEdit.addCaretListener(new CaretListener(){
        	public void caretUpdate(CaretEvent ce){
        		//deb  et fin pour la sélection
        		int deb = Math.min(ce.getDot(), ce.getMark());
        		int fin = Math.max(ce.getDot(), ce.getMark());
        		int lng = fin-deb;
        		
        		//Calcul pour afficher l'état de position du curseur
        		int colonne = 1;
        		int ligne = 1;
        		try {
        			int caretpos = txtEdit.getCaretPosition();
                    ligne = txtEdit.getLineOfOffset(caretpos);
                    
                    colonne = caretpos - txtEdit.getLineStartOffset(ligne);
        			
        			lblStatut.setText("Lignes : "+ (ligne+1) +", Colonnes : " + (colonne+1));
        			ligne += 1;
        		} catch (BadLocationException e) {
        			e.printStackTrace();
        		}
        		
        		if (deb != getDebSelect() || lng != getLngSelect()) {
        			
					setSelect(deb, lng);
					int[] pos = {deb, lng};
					selectActionPerformed(pos);
				}
        	}
        });
        
        //Ajout écouteur keys sur txtEdit
        txtEdit.addKeyListener(new KeyListener() {
        	
        	/**
        	 * Procédure sur le comportement d'une touche tapée
        	 * 
        	 * @param e : KeyEvent
        	 */
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume(); // Annule le comportement par défaut
				char keyChar = e.getKeyChar();
				if (keyChar != '\b') {
					lastChar = keyChar;
					insertTxtAction(keyChar);
				}
			}
			
			/**
			 * Procédure sur le comportement d'une touche reléchée
			 * 
			 * @param e : KeyEvent.
			 */
			@Override
			public void keyReleased(KeyEvent e) {}

			/**
			 * Procédure sur le comportement d'une touche appuyée prolongée.
			 * 
			 * @param e : KeyEvent.
			 */
			@Override
			public void keyPressed(KeyEvent e) {
				if (!e.isActionKey()) {
					e.consume(); // Annule le comportement par défaut
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						int[] pos = {getDebSelect(),getLngSelect()};
						cmdSupp.execute(pos);
					}
				}
			}
        });

        // Placement des layouts
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTool, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlStatut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            	.addComponent(pnlTool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(null);
    }
    
    //--- Setters ---
    
    /**
     * Procédure qui modifie le texte.
     * 
     * @param leTexte
     */
    public void setTxt(String leTexte){
    	this.txtEdit.setText(leTexte);
    }
    
    /**
     * Procédure qui permet d'iniitialiser le début et la longueur d'un texte sélectionné.
     * 
     * @param deb : début de la sélection. int.
     * @param lng : longueur de la sélection. int.
     */
    private void setSelect(int deb, int lng) {
    	this.debSelect = deb;
		this.lngSelect = lng;
	}
    
    /**
     * Procédure qui initialiser les commandes.
     * 
     * @param mapCmds : map de commandes . <String, command.Command>
     */
    public void setCmds(@SuppressWarnings("rawtypes") Map<String,command.Command> mapCmds){
    	for(@SuppressWarnings("rawtypes") Map.Entry<String,command.Command> commande : mapCmds.entrySet()){
    		switch(commande.getKey()){
    		case "Copier":
    			this.cmdCopy = (command.Copier) commande.getValue();
    			break;
    		case "Couper":
    			this.cmdCut = (command.Couper) commande.getValue();
    			break;
    		case "Coller":
    			this.cmdPast = (command.Coller) commande.getValue();
    			break;
    		case "Insert":
    			this.cmdInsText = (command.InsertTxt) commande.getValue();
    			break;
    		case "Select":
    			this.cmdSelect = (command.Selectionner) commande.getValue();
    			break;
    		case "Supp":
    			this.cmdSupp = (command.Supprime) commande.getValue();
    			break;
    		}
    	}
    }
    
    //--- Getters ---
    
    /**
     * Fonction qui retourne le texte.
     * 
     * @return String
     */
    public String getText(){
    	return this.txtEdit.getText();
    }
    
    /**
     * Fonction qui retourne le début de la sélection.
     * 
     * @return int
     */
    public int getDebSelect() {
		return debSelect;
	}
    
    /**
     * Fonction qui retourne la longueur de la sélection.
     * 
     * @return int
     */
    public int getLngSelect() {
    	return this.lngSelect;
    }
    
    /**
     * Fonction qui retourne le dernier caractère.
     * @return char
     */
    public char getLastChar() {
		return this.lastChar;
	}
    
    //--- Actions Commands ---
    
    /**
     * Procédure qui appelle la commande copier.
     * 
     * @param evt
     */
    private void copyActionPerformed(java.awt.event.ActionEvent evt) {
    	this.cmdCopy.execute(getLngSelect());
    	
    }
    
    /**
     * Procédure qui appelle la commande couper.
     * 
     * @param evt
     */
    private void cutActionPerformed(java.awt.event.ActionEvent evt) {
    	int[] pos = {getDebSelect(),getLngSelect()};
    	this.cmdCut.execute(pos);
    }
    
    /**
     * Procédure qui appelle la commande coller.
     * 
     * @param evt
     */
    private void pastActionPerformed(java.awt.event.ActionEvent evt){
    	this.cmdPast.execute(this.getDebSelect());
    }
    
    /**
     * Procédure qui appelle la commande insertTxt.
     * 
     * @param caract : caractère d'insertion
     */
    private void insertTxtAction(char caract){
    	this.cmdInsText.execute(caract);
    }
    
    /**
     * Procédure qui appelle la commande selectTxt.
     * 
     * @param pos : position de la sélection. Début de la sélection / longueur de la sélection.
     */
    private void selectActionPerformed(int[] pos){
    	this.cmdSelect.execute(pos);
    }
    
    //--- Autres méthodes ---
    
    /**
	 * Procédure qui met à jour la zone de texte pour afficher les modifications apportées au
	 * buffer.
	 * 
	 * @param text : texte à ajouter dans le JTextArea.
	 * @param deb : début de l'ajout du texte.
	 * @param lng : longueur.
	 */
	public void update(String text, int deb, int lng) {
		this.setTxt(text);
		this.txtEdit.setSelectionStart(deb);
		this.txtEdit.setSelectionEnd(deb + lng);
		this.setSelect(deb, lng);
	}
	
	/**
     * Fonction qui retourne un tableau de couleur suivant une chaine hexadécimale.
     * 
     * @param rgb : couleur hexadécimale.
     * @return int[] color RGB.
     */
    @SuppressWarnings("unused")
	private static int[] getRGB(final String rgb){
        final int[] ret = new int[3];
        for (int i = 0; i < 3; i++){
            ret[i] = Integer.parseInt(rgb.substring(i * 2, i * 2 + 2), 16);
        }
        return ret;
    }
	
    //--- Déclaration des propriétées ---
    
    private javax.swing.JMenuItem btnCopy;
    private javax.swing.JButton btnBisCopy;
    private command.Copier cmdCopy;
    private javax.swing.JMenuItem btnCut;
    private javax.swing.JButton btnBisCut;
    private command.Couper cmdCut;
    private javax.swing.JMenuItem btnPast;
    private javax.swing.JButton btnBisPast;
    private command.Coller cmdPast;
    private command.InsertTxt cmdInsText;
    private command.Selectionner cmdSelect;
    private command.Supprime cmdSupp;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel lblStatut;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JPanel pnlStatut;
    private javax.swing.JPanel pnlText;
    private javax.swing.JPanel pnlTool;
    protected javax.swing.JTextArea txtEdit;
    private javax.swing.JToolBar toolbar;
    private int debSelect;
    private int lngSelect;
    private char lastChar;
    private static Properties properties = new Properties(); //Fichier des propriétées
}
