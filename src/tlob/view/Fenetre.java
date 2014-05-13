package tlob.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import tlob.model.*;
import tlob.controller.*;

public class Fenetre extends JFrame implements KeyListener{
	
	private static final long serialVersionUID = 1L;

	private Panel panel;
	private GameController controller;
	
	public Fenetre(Level level, final GameController controller, LoadIAD loadIAD)  {
	    setVisible(true) ;
		setSize(15*41, 15*42+5+90);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addKeyListener(this);
		this.controller = controller;
		panel = new Panel(level, loadIAD);
		getContentPane().add(panel);
		Timer timer = new Timer(30, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.update();
				repaint();
			}
		});
		timer.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_RIGHT)
	    	controller.setRightPressed(true);
    	else if(keyCode == KeyEvent.VK_LEFT) {
    		controller.setLeftPressed(true);
    	}
    	else if(keyCode == KeyEvent.VK_DOWN) {
    		controller.setDownPressed(true);
    	}
    	else if(keyCode == KeyEvent.VK_UP) {
    		controller.setUpPressed(true);
    	}
    	else if(keyCode == KeyEvent.VK_X){
    		controller.setFireArrow(true);
    	}
    	else if(keyCode == KeyEvent.VK_SPACE){
    		controller.setSetBomb(true);
    	}
    	else if(keyCode == KeyEvent.VK_C) {
    		controller.setUseStaff(true);
    	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//liste.get(0).setActualFrame(1);
	    int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_RIGHT){
	    	controller.setRightPressed(false);
	    }
    	else if(keyCode == KeyEvent.VK_LEFT){
    		controller.setLeftPressed(false);
    	}
    	else if(keyCode == KeyEvent.VK_DOWN) {
    		controller.setDownPressed(false);
    	}
    	else if(keyCode == KeyEvent.VK_UP) {
    		controller.setUpPressed(false);
    	}

		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
