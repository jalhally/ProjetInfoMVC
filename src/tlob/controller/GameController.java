package tlob.controller;


import java.util.List;
import tlob.model.*;
import tlob.view.*;

public class GameController {
	
	boolean rightPressed = false;
	boolean leftPressed = false;
	boolean downPressed = false;
	boolean upPressed = false;
	boolean enterPressed = false;
	boolean fireArrow = false;
	boolean setBomb = false;
	boolean useStaff = false;
	
	private List<Link> link;
	private List<Monster> monster;
	private List<Bomb> bomb;
	private List<Arrow> arrow;
	private List<BombDeflagration> bombDeflagration;
	private List<Menu> menu;
	private GameInteraction interaction;
	private int status = 0; // 0 = menu, 1 = multi, 2 = solo
	private int k = 2; // va modifier le status dans le menu
	private Level level;
	private boolean pressedOnce = true; // premiere foi qu on appuie
	private Sound sound = new Sound();
	
	public GameController(Level level){
		this.level = level;
		this.menu = level.getMenu();
		this.link = level.getLink();
		this.monster = level.getMonster();
		this.bomb = level.getBomb();
		this.arrow = level.getArrow();
		this.bombDeflagration = level.getBombDeflagration();
		this.interaction = new GameInteraction(level);
		this.sound.playSound("swag");

	}
		
	public void setLink (List<Link> link){
		this.link = link;
	}
	
	public void setMonster(List<Monster> monster){
		this.monster = monster;
	}
	
	public void setBomb (List<Bomb> bomb){
		this.bomb = bomb;
	}
	
	public void setArrow (List<Arrow> arrow){
		this.arrow = arrow;
	}
	
	public void setBombDeflagration (List<BombDeflagration> bombDeflagration){
		this.bombDeflagration = bombDeflagration;
	}
	
	public void setInteraction (GameInteraction interaction){
		this.interaction = interaction;
	}
	
	public void update() {
		if (status == 0){
			if(sound.isFinished(sound.getAudioStream()))
			{
				sound.playSound("swag");
			}
			if (downPressed && pressedOnce && k > 1 ){
				System.out.println(k);
				for (int i = 0; i<menu.size();i++){
					if(menu.get(i).getStatus() == k)
						menu.get(i).setName("res/Rocks");
					else if(menu.get(i).getStatus() == k - 1)
						menu.get(i).setName("res/Bomb");
				}
				k-=1;
				pressedOnce = false;

			}
			else if (upPressed && pressedOnce & k < 2){
				System.out.println(k);
				for (int i = 0; i<menu.size();i++){
					if(menu.get(i).getStatus() == k)
						menu.get(i).setName("res/Rock");
					else if(menu.get(i).getStatus() == k + 1)
						menu.get(i).setName("res/Bomb");

				}
				k+=1;
				pressedOnce = false;
			}
			else if (!downPressed && !upPressed && !enterPressed){
				pressedOnce = true;
			}
			
			else if (enterPressed){ // lance le solo
				status = k;
				if(status == 2){
					sound.soundEnd(sound.getAudioStream());
					sound.playSound("yolo");
				}
				level.setStatus(status);

			}
		}
		else if (status == 1){

			// mode multi
	
		}
		
		else if(status == 2){
				if(sound.isFinished(sound.getAudioStream()))
			{
				sound.playSound("yolo");
			}
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
						Sound soundBomb = new Sound();
						soundBomb.playSound("bomb");
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
	
	public void setEnterPressed(boolean bool){
		this.enterPressed = bool;
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
