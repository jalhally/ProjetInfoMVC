package tlob.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import tlob.model.*;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Level level;
	private static int dec = 90;
	private LoadIAD loadIAD;
	
	Image bg = Toolkit.getDefaultToolkit().getImage("res/BackgroundForest.png");
	Image heart = Toolkit.getDefaultToolkit().getImage("res/Heart.png");
	Image statusBar = Toolkit.getDefaultToolkit().getImage("res/StatusBar - Copie.png");
	Image Char0 = Toolkit.getDefaultToolkit().getImage("res/Char0.png");
	Image Char1 = Toolkit.getDefaultToolkit().getImage("res/Char1.png");
	Image Char2 = Toolkit.getDefaultToolkit().getImage("res/Char2.png");
	Image Char3 = Toolkit.getDefaultToolkit().getImage("res/Char3.png");
	Image Char4 = Toolkit.getDefaultToolkit().getImage("res/Char4.png");
	Image Char5 = Toolkit.getDefaultToolkit().getImage("res/Char5.png");
	Image Char6 = Toolkit.getDefaultToolkit().getImage("res/Char6.png");
	Image Char7 = Toolkit.getDefaultToolkit().getImage("res/Char7.png");
	Image Char8 = Toolkit.getDefaultToolkit().getImage("res/Char8.png");
	Image Char9 = Toolkit.getDefaultToolkit().getImage("res/Char9.png");
	private Image charNumber[]={Char0,Char1,Char2,Char3,Char4,Char5,Char6,Char7,Char8,Char9};
	
	public Panel(Level level, LoadIAD loadIAD) {
		this.level = level;
		this.loadIAD = loadIAD;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		if(level.getStatus() == 0){
			for (Menu menu : level.getMenu()){
				g.drawImage(loadIAD.stringToIAD(menu.getName()).getImage(), menu.getXPos(), menu.getYPos()+dec,null);
			}
		}
		else if (level.getStatus() == 2){
			g.drawImage(statusBar,0,0,null);
			for(int i =0; i<15;i++){
				for(int j=0;j<15;j++) {
					g.drawImage(bg,i*40,j*40+dec,null);				
				}
			}
			for(Decor decor : level.getDecor()) {
				g.drawImage(loadIAD.stringToIAD(decor.getName()).getImage(), decor.getXPos(), decor.getYPos()+dec,null);
			}
			
			for(Bomb bomb : level.getBomb()) {
				g.drawImage(loadIAD.stringToIAD(bomb.getName()).getImage(), bomb.getXPos(), bomb.getYPos()+dec,null);
			}
			
			for(Bonus bonus : level.getBonus()){
				g.drawImage(loadIAD.stringToIAD(bonus.getName()).getImage(), bonus.getXPos()+10, bonus.getYPos()+dec+10,null);
			}
			
			for(Link link : level.getLink()) {
				g.drawImage(loadIAD.stringToIAD(link.getName()).getImageAnime(link), link.getXPos(), link.getYPos()+dec,null);
				for(int i=0; i<link.getLifePoint();i++) {
					g.drawImage(heart,180+i*15,45,null);				
				}
				g.drawImage(charNumber[link.getNumberBomb()],485,42,null);
				//g.drawImage(charNumber[l.getNumberArrow()-data2.size()],0,0,null);
			}
			
			for(Arrow arrow : level.getArrow()) {
				g.drawImage(loadIAD.stringToIAD(arrow.getName()).getImageAnime(arrow), arrow.getXPos(), arrow.getYPos()+dec,null);
			}
			
			for(Monster monster : level.getMonster()) {
				g.drawImage(loadIAD.stringToIAD(monster.getName()).getImageAnime(monster), monster.getXPos(), monster.getYPos()+dec,null);
			}
			
			for(BombDeflagration bombDef : level.getBombDeflagration()) {
				for(int j = 0; j< bombDef.getUp().size(); j++){
					if(j==bombDef.getUp().size()-1){
						g.drawImage(loadIAD.stringToIAD(bombDef.getName()).getImageDirection(2).get(1), bombDef.getXPos(), bombDef.getUp().get(j)+dec,null);
					}
					else{
						g.drawImage(loadIAD.stringToIAD(bombDef.getName()).getImageDirection(2).get(0), bombDef.getXPos(), bombDef.getUp().get(j)+dec,null);
					}
				}
				for(int j = 0; j< bombDef.getDown().size(); j++){
					if(j==bombDef.getUp().size()-1){
						g.drawImage(loadIAD.stringToIAD(bombDef.getName()).getImageDirection(3).get(1), bombDef.getXPos(), bombDef.getDown().get(j)+dec,null);
					}
					else{
						g.drawImage(loadIAD.stringToIAD(bombDef.getName()).getImageDirection(3).get(0), bombDef.getXPos(), bombDef.getDown().get(j)+dec,null);
					}
				}
				for(int j = 0; j< bombDef.getLeft().size(); j++){
					if(j==bombDef.getUp().size()-1){
						g.drawImage(loadIAD.stringToIAD(bombDef.getName()).getImageDirection(0).get(1), bombDef.getLeft().get(j), bombDef.getYPos()+dec,null);
					}
					else{
						g.drawImage(loadIAD.stringToIAD(bombDef.getName()).getImageDirection(0).get(0), bombDef.getLeft().get(j), bombDef.getYPos()+dec,null);
					}
				}
				for(int j = 0; j< bombDef.getRight().size(); j++){
					if(j==bombDef.getUp().size()-1){
						g.drawImage(loadIAD.stringToIAD(bombDef.getName()).getImageDirection(1).get(1), bombDef.getRight().get(j), bombDef.getYPos()+dec,null);
					}
					else{
						g.drawImage(loadIAD.stringToIAD(bombDef.getName()).getImageDirection(1).get(0), bombDef.getRight().get(j), bombDef.getYPos()+dec,null);
					}
				}
			}
			}
		}
	}
