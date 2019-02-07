import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.HashMap;

class UneFenetre extends JFrame implements ActionListener
{
    private final int LARG=1000, HAUT=500, NB_BUTTON = 10;
    private HashMap<JButton, Thread> threads;
    private HashMap<JButton, Boolean> estArrete;

    private boolean interrupted = false;

    public UneFenetre()
    {
    	super("Une fenêtre");
    	this.setSize(LARG, HAUT);
    	this.setVisible(true);
    	
        threads = new HashMap<JButton, Thread>();
        estArrete = new HashMap<JButton, Boolean>();
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	
    	
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.BOTH;

    	for(int i = 0; i < NB_BUTTON; i++){
            
    		JButton new_button = new JButton("Arrêt/Continu");
    		new_button.addActionListener(this);


    		c.gridy = i;
    		c.gridx = 0;
    		c.gridwidth = 1;
            c.weightx = 0.75;
            c.weighty = 1;
            
        	UnMobile sonMobile = new UnMobile(LARG*3/4, 40);
            threads.put(new_button, new Thread(sonMobile));
            estArrete.put(new_button, false);
            threads.get(new_button).start();
    		container.add(sonMobile, c);

    		
        	c.gridwidth = 1;
    		c.gridy = i;
    		c.gridx = 1;
            c.weightx = 0.25;
            c.weighty = 1;
    		
    		container.add(new_button, c);
    		
    	}
    	
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() instanceof JButton){
            JButton button = (JButton)arg0.getSource();
            if(estArrete.get(button) == false)
            {
                threads.get(button).suspend();
                estArrete.put(button, true);
            }
            else
            {
                threads.get(button).resume();
                estArrete.put(button, false);

            }
            
		}
		
	}
    
}
