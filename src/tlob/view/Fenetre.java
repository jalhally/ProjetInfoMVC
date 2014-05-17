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
	    setSize(800, 15*42+117);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	public void setGameController (GameController controller){
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    
	    if (keyCode == KeyEvent.VK_D)
	    	controller.setRightPressed(true);
	    
    	else if(keyCode == KeyEvent.VK_Q) {
    		controller.setLeftPressed(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_P)
    		controller.setPausePressed(true);
	    
    	else if(keyCode == KeyEvent.VK_S) {
    		controller.setDownPressed(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_Z) {
    		controller.setUpPressed(true);
    	}
	    
    	else if (keyCode == KeyEvent.VK_ENTER){
    		controller.setEnterPressed(true);
    	}
    	
    	else if(keyCode == KeyEvent.VK_V){
    		controller.setFireArrow(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_SPACE){
    		controller.setSetBomb(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_C) {
    		controller.setUseStaff(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_ESCAPE) {
    		controller.setEscape(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_UP) {
    		controller.setUpPressed2(true);
    		controller.setUpPressedMenu(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_RIGHT) {
    		controller.setRightPressed2(true);
    		controller.setRightPressedMenu(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_LEFT) {
    		controller.setLeftPressed2(true);
    		controller.setLeftPressedMenu(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_DOWN) {
    		controller.setDownPressed2(true);
    		controller.setDownPressedMenu(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_U) {
    		controller.setSetBomb2(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_I) {
    		controller.setFireArrow2(true);
    	}
	    
    	else if(keyCode == KeyEvent.VK_O) {
    		controller.setUseStaff2(true);
    	}
	    
	    
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//liste.get(0).setActualFrame(1);
	    int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_D){
	    	controller.setRightPressed(false);
	    }
	    
    	else if(keyCode == KeyEvent.VK_Q){
    		controller.setLeftPressed(false);
    	}
	    
    	else if(keyCode == KeyEvent.VK_ESCAPE) {
    		controller.setEscape(false);
    	}
	    
    	else if(keyCode == KeyEvent.VK_P)
    		controller.setPausePressed(false);
	    
    	else if(keyCode == KeyEvent.VK_S) {
    		controller.setDownPressed(false);
    	}
	    
    	else if(keyCode == KeyEvent.VK_Z) {
    		controller.setUpPressed(false);
    	}
	    
	    if (keyCode == KeyEvent.VK_RIGHT){
	    	controller.setRightPressed2(false);
    		controller.setRightPressedMenu(false);
	    }
	    
    	else if(keyCode == KeyEvent.VK_LEFT){
    		controller.setLeftPressed2(false);
    		controller.setLeftPressedMenu(false);
    	}
	    
    	else if(keyCode == KeyEvent.VK_DOWN) {
    		controller.setDownPressed2(false);
    		controller.setDownPressedMenu(false);
    	}
	    
    	else if(keyCode == KeyEvent.VK_UP) {
    		controller.setUpPressed2(false);
    		controller.setUpPressedMenu(false);
    	}
	    
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
