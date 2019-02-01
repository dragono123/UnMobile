import java.awt.Container;

import javax.swing.JFrame;

class UneFenetre extends JFrame 
{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre()
    {
	// ajouter sonMobile a la fenetre
	// creer une thread laThread avec sonMobile
	// afficher la fenetre
	// lancer laThread 
    	super("Une fenêtre");
    	sonMobile = new UnMobile(LARG, HAUT);
    	this.setSize(LARG, HAUT);
    	this.setVisible(true);
    	Container container = getContentPane();
    	
    	container.add(sonMobile);
    	
    	Thread thread = new Thread(sonMobile);
    	thread.start();
    	
    }
}
