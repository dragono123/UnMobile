import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class UneFenetre extends JFrame implements ActionListener
{
    UnMobile sonMobile[];
    private final int LARG=1000, HAUT=500, NB_BUTTON = 10;
    private Thread[] thread;
    private JButton[] button;
    private boolean interrupted = false;
    public UneFenetre()
    {
	// ajouter sonMobile a la fenetre
	// creer une thread laThread avec sonMobile
	// afficher la fenetre
	// lancer laThread 
    	super("Une fenêtre");
    	sonMobile = new UnMobile[NB_BUTTON];
    	this.setSize(LARG, HAUT);
    	this.setVisible(true);
    	
    	button = new JButton[NB_BUTTON];
    	thread = new Thread[NB_BUTTON];
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	
    	
    	GridBagConstraints c = new GridBagConstraints();
    	
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx = 0;
    	c.gridy = 0;

    	for(int i = 0; i < NB_BUTTON; i++){

        	c.gridwidth = 1;
    		button[i] = new JButton("Arrêt/Continu");
    		button[i].addActionListener(this);
    		container.add(button[i], c);
    		
    		c.gridx = 1;
    		c.gridwidth = 4;
    		
        	sonMobile[i] = new UnMobile(LARG - 200, 40);
        	thread[i] = new Thread(sonMobile[i]);
            thread[i].start();
            
    		container.add(sonMobile[i], c);
    		
    		c.gridx = 0;
    		c.gridy += 1;
    	}
    	
    	
    	
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == button){

		}
		
	}
    
}
