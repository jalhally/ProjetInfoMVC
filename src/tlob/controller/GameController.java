package tlob.controller;


import java.util.List;
import tlob.model.*;

public class GameController {
	
	boolean rightPressed = false;
	boolean leftPressed = false;
	boolean downPressed = false;
	boolean upPressed = false;
	boolean fireArrow = false;
	boolean setBomb = false;
	boolean useStaff = false;
	
	private List<Link> link;
	private List<Monster> monster;
	private List<Bomb> bomb;
	private List<Arrow> arrow;
	private List<BombDeflagration> bombDeflagration;
	private GameInteraction interaction;
	
	public GameController(Level level){
		this.link = level.getLink();
		this.monster = level.getMonster();
		this.bomb = level.getBomb();
		this.arrow = level.getArrow();
		this.bombDeflagration = level.getBombDeflagration();
		this.interaction = new GameInteraction(level);
	}
	
	public void update() {
		
		for(int i = 0; i < link.size(); i++){
			
			if(link.get(i).getInvincible() == 0){
				link.get(i).tickInvicible();
			}
			
			interaction.linkInteraction(link.get(i));

			if(rightPressed){
				link.get(0).setName("res/LinkRun");
		    	link.get(0).moveRight();
				
			}
			if(leftPressed){
				link.get(0).setName("res/LinkRun");
		    	link.get(0).moveLeft();
			}
			
			if(downPressed){
				link.get(0).setName("res/LinkRun");
		    	link.get(0).moveDown();
			}
			
			if(upPressed){
				link.get(0).setName("res/LinkRun");
		    	link.get(0).moveUp();
			}
			
			if(fireArrow){
				link.get(0).setName("res/LinkArrow");
				link.get(0).fireArrow(arrow);
				System.out.print(link.get(0).getActualFrame());
				if(link.get(0).getActualFrame() == 6){
					fireArrow = false;
					link.get(0).setActualFrame(1);
				}
			}
			if(setBomb){
				if(bomb.size()< link.get(0).getNumberBomb()){
					link.get(0).setBomb(bomb);				
				}
				setBomb = false;
			}
			if(useStaff==true && link.get(0).getStaff()!=-1) {
				if(link.get(0).getStaff()==0) {
				for (Monster m : monster) {
					m.getDamage(1);			
				}
				useStaff=false; 
				link.get(0).setStaff(-1); 
			}
				else if(link.get(0).getStaff()==1) {
					for (Monster m : monster) {
						m.setFrozen();
						m.tickFrozen();	
						if(m.getFrozen()==1) {
							useStaff=false; 
							link.get(0).setStaff(-1); 
						}
					
					}
				}
			}
		}
		
		
		if(monster.size() > 0){
			for(int i = 0; i < monster.size(); i++){
				if(monster.get(i).getInvincible() == 0){
					monster.get(i).tickInvicible();
				}
				if(monster.get(i).getLifePoint() == 0){
					monster.remove(i);
				}
			}
		}	

		if(arrow.size()>0){
			for(int p = 0; p < arrow.size(); p++){
				int a = interaction.arrowInteraction(arrow.get(p));
				if(a != 0){
					if(a == 2){
						arrow.get(p).tick(5);
						//arrow.get(p).setActualFrame(1);
						if(arrow.get(p).getTime() == 15){
							arrow.remove(p);
						}
					}
					else{
						arrow.remove(p);
					}
				}
			}
		}

		if(bomb.size()>0){
			for(int p = 0; p < bomb.size(); p++){
				interaction.bombInteraction(bomb.get(p));
				bomb.get(p).tick();
				if(bomb.get(p).getTime() == 15){ //changer dans deflagration si changement de temps
					bombDeflagration.add(new BombDeflagration(bomb.get(p).getXPos(),bomb.get(p).getYPos(),"res/Deflagration",2));
					bomb.remove(p);
				}
			}
		}
		if(bombDeflagration.size()>0){
			for(int p = 0; p < bombDeflagration.size(); p++){
				bombDeflagration.get(p).tick(2);
				if(bombDeflagration.get(p).getPortee() < link.get(0).getRangeBomb()*4+2){
					interaction.deflagrationAppear(bombDeflagration.get(p), link.get(0).getRangeBomb());
					interaction.defInteraction(bombDeflagration.get(p));
				}
				else{
					bombDeflagration.remove(p);
				}
			}
		}
		
		/*
		if(feu.size()>0){
			for(int p = 0; p < feu.size(); p++){
				feu.get(p).tick();
				feu.get(p).move();
				//System.out.println(feu.get(p).getXPos()+ " " + feu.get(p).getYPos());
					if(feu.get(p).getList().size() < feu.get(p).getPos()-1){
						feu.remove(p);
					}
			}
		}
		*/
	}
	
	public void setRightPressed(boolean bool){
		this.rightPressed = bool;
	}
	
	public void setLeftPressed(boolean bool){
		this.leftPressed = bool;
	}
	
	public void setDownPressed(boolean bool){
		this.downPressed = bool;
	}
	
	public void setUpPressed(boolean bool){
		this.upPressed = bool;
	}
	
	public void setFireArrow(boolean bool){
		this.fireArrow = bool;
	}
	
	public void setSetBomb(boolean bool){
		this.setBomb = bool;
	}
	
	public void setUseStaff(boolean bool){
		this.useStaff = bool;
	}
}
