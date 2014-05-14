package tlob.controller;

import java.util.List;

import tlob.model.*;
import tlob.view.Sound;

public class GameInteraction {
	
	private List<Link> link;
	private List<Decor> decor;
	private List<Monster> monster;
	private List<Bomb> bomb;
	private List<Bonus> bonus;
	private Map map;
	
	public GameInteraction(Level level){
		this.link = level.getLink();
		this.decor = level.getDecor();
		this.monster = level.getMonster();
		this.bomb = level.getBomb();
		this.bonus = level.getBonus();
		this.map = level.getMap();
	}
	
	private int touchDecor(int x1, int y1, int x2, int y2){ 
		if(Math.abs(x1-x2)<40 && Math.abs(y1-y2)<30){
			if(x1-x2 < 0){
				return 0; //GAUCHE
			}
			else{
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<30 && 40>Math.abs(y1-y2)){
			if(y1-y2 < 0){
				return 2; //HAUT
			}
			else{
				return 3; //BAS
			}
		}
		else{
			return -1;
		}
	}
	
	public int touchDecorB(int x1, int y1, int x2, int y2){ 
		if(Math.abs(x1-x2)<35 && Math.abs(y1-y2)<25){
			if(x1-x2 < 0){
				//System.out.println("pd");
				return 0; //GAUCHE
			}
			else{
				//System.out.println("pd");
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<25 && 35>Math.abs(y1-y2)){
			if(y1-y2 < 0){
				//System.out.println("pd");
				return 2; //HAUT
			}
			else{
				//System.out.println("pd");
				return 3; //BAS
			}
		}
		else{
			//System.out.println("hihihihi");
			return -1;
		}
	}
	
	private int touchMonster(int x1, int y1, int x2, int y2){ 
		if(Math.abs(x1-x2)<30 && Math.abs(y1-y2)<25){
			if(x1-x2 < 0){
				return 0; //GAUCHE
			}
			else{
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<25 && 30>Math.abs(y1-y2)){
			if(y1-y2 < 0){
				return 2; //HAUT
			}
			else{
				return 3; //BAS
			}
		}
		else{
			return -1;
		}
	}
	
	private int touchArrow(int x1, int y1, int x2, int y2){ 
		if(Math.abs(x1-x2)<30 && Math.abs(y1-y2)<20){
			if(x1-x2 < 0){
				return 0; //GAUCHE
			}
			else{
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<20 && 30>Math.abs(y1-y2)){
			if(y1-y2 < 0){
				return 2; //HAUT
			}
			else{
				return 3; //BAS
			}
		}
		else{
			return -1;
		}
	}
	
	private int touchBomb(int x1, int y1, int x2, int y2){ 
		if(Math.abs(x1-x2)<40 && Math.abs(x1-x2)>30 && Math.abs(y1-y2)<25){
			if(x1-x2 < 0){
				return 0; //GAUCHE
			}
			else{
				return 1; //DROITE
			}
		}
		else if(Math.abs(x1-x2)<30 && 40>Math.abs(y1-y2) && Math.abs(y1-y2)>25){
			if(y1-y2 < 0){
				return 2; //HAUT
			}
			else{
				return 3; //BAS
			}
		}
		else{
			return -1;
		}
	}
	
	public void linkInteraction(Link link){
		link.setR(1);
		link.setL(1);
		link.setD(1);
		link.setU(1);
		for(int i = 0; i < decor.size(); i++){
			if(touchDecor(link.getXPos(), link.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1 && decor.get(i).getClass() == Door.class){
				int line = ((Door) decor.get(i)).getLine();
				int column = ((Door) decor.get(i)).getColumn();
				int level = ((Door) decor.get(i)).getLevel();
				char[][] tableau = new char[16][16];

				map.saveMap(map.listToMap(decor, monster));
				map.setLevel(Integer.toString(level + Integer.parseInt(map.getLevel())));
				map.setRoomLine(Integer.toString(Integer.parseInt(map.getRoomLine()) - line));
				map.setRoomColumn(Integer.toString(Integer.parseInt(map.getRoomColumn()) + column));
				tableau = map.loadRoom();

				decor.removeAll(decor);
				List<Decor> decor2 = map.mapToListDecor(tableau);
				for(int j = 0; j < decor2.size();j++){
					decor.add(decor2.get(j));
				}
				
				monster.removeAll(monster);
				List<Monster> monster2 = map.mapToListMonster(tableau);
				for(int j = 0; j < monster2.size(); j++){
					monster.add(monster2.get(j));
				}
				
				link.setXPos(40*8);
				link.setYPos(40*8);
				break;
			}
			
			if(decor.get(i).getClass() != Floor.class){
				int a = touchDecor(link.getXPos(),link.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos());
				if(a == 0)
					link.setR(0);
				if(a == 1)
					link.setL(0);
				if(a == 2)
					link.setD(0);
				if(a == 3)
					link.setU(0);
			}
		}
		for(int i = 0; i < monster.size(); i++){
			int a = touchMonster(link.getXPos(),link.getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos());
			if(a == 0){
				if(link.getR() != 0 && link.getInvincible() == 1){
					for(int j = 0; j < 3; j++){
						link.setXPos(link.getXPos() - 5);
						for(int k = 0; k < decor.size(); k++){
							if(touchDecor(link.getXPos(),link.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != 0){
								link.setR(0);
							}
						}
					}
				}
				link.getDamage(1);
			}
			if(a == 1){
				if(link.getL() != 0 && link.getInvincible() == 1){
					for(int j = 0; j < 3; j++){
						link.setXPos(link.getXPos() + 5);
						for(int k = 0; k < decor.size(); k++){
							if(touchDecor(link.getXPos(),link.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != 1){
								link.setL(0); 
							}
						}
					}
				}
				link.getDamage(1);
			}
			if(a == 2){
				if(link.getD() != 0 && link.getInvincible() == 1){
					for(int j = 0; j < 3; j++){
						link.setYPos(link.getYPos() - 5);
						for(int k = 0; k < decor.size(); k++){
							if(touchDecor(link.getXPos(),link.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != 2){
								link.setD(0);
							}
						}
					}
				}
				link.getDamage(1);
			}
			if(a == 3){
				if(link.getU() != 0 && link.getInvincible() == 1){
					for(int j = 0; j < 3; j++){
						link.setYPos(link.getYPos() + 5);
						for(int k = 0; k < decor.size(); k++){
							if(touchDecor(link.getXPos(),link.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != 3){
								link.setU(0);
							}
						}
					}
				}
				link.getDamage(1);
			}
		}
		for(int i = 0; i < bomb.size(); i++){
			int a = touchBomb(link.getXPos(),link.getYPos(),bomb.get(i).getXPos(),bomb.get(i).getYPos());
			if(a == 0){
				link.setR(0);
				if(link.getDirection() == 1 && link.getGauntlet() == true){
					bomb.get(i).setDirection(link.getDirection());
				}
			}
			if(a == 1){
				link.setL(0);
				if(link.getDirection() == 0 && link.getGauntlet() == true){
					bomb.get(i).setDirection(link.getDirection());
				}
			}
			if(a == 2){
				link.setD(0);
				if(link.getDirection() == 3 && link.getGauntlet() == true){
					bomb.get(i).setDirection(link.getDirection());
				}
			}
			if(a == 3){
				link.setU(0);
				if(link.getDirection() == 2 && link.getGauntlet() == true){
					bomb.get(i).setDirection(link.getDirection());
				}
			}
		}
		for(int i = 0; i < bonus.size(); i++){
			if(touchMonster(link.getXPos(),link.getYPos(),bonus.get(i).getXPos(),bonus.get(i).getYPos()) != -1){
				bonus.get(i).activation(link);
				bonus.remove(i);
			}
		}
	}
	
	public int arrowInteraction(Arrow arrow){
		for(int i = 0; i < link.size(); i++){
			if(((arrow.getDirection() == 0 || arrow.getDirection() == 1) && (arrow.getXPos() > arrow.getX() + 40)) 
					|| ((arrow.getDirection() == 2 || arrow.getDirection() == 3) && (arrow.getYPos() > arrow.getY() + 40))){
				if(touchArrow(arrow.getXPos(), arrow.getYPos(),link.get(i).getXPos(),link.get(i).getYPos()) != -1){
					link.get(i).getDamage(1);
					return 1;
				}
			}
		}
		for(int i = 0; i < monster.size(); i++){
			if(touchArrow(arrow.getXPos(),arrow.getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
				monster.get(i).getDamage(1);
				return 1;
			}
		}
		for(int i = 0; i < decor.size(); i++){
			if(touchArrow(arrow.getXPos(),arrow.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
					&& decor.get(i).getClass() != Floor.class){
				return 2;
			}
		}
		for(int i = 0; i < bomb.size(); i++){
			if(touchArrow(arrow.getXPos(),arrow.getYPos(),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
				bomb.get(i).setTime(15);
				return 3;
			}
		}
		arrow.move();
		return 0;
	}
	
	public void bombInteraction(Bomb bomb){
		for(int i = 0; i < this.bomb.size(); i++){
			if(bomb.getDirection() == 0){
				if(touchDecorB(bomb.getXPos()-15, bomb.getYPos(), this.bomb.get(i).getXPos(), this.bomb.get(i).getYPos()) != -1
						&& this.bomb.get(i).getXPos() != bomb.getXPos()){ //&& bomb.get(i).getYPos() != getYPos()){
					bomb.setXPos(this.bomb.get(i).getXPos()+40);
					bomb.setDirection(-1);
				}
			}
			if(bomb.getDirection() == 1){
				if(touchDecorB(bomb.getXPos()+15, bomb.getYPos(),this.bomb.get(i).getXPos(),this.bomb.get(i).getYPos()) != -1
						&& this.bomb.get(i).getXPos() != bomb.getXPos()){
					bomb.setXPos(this.bomb.get(i).getXPos()-40);
					bomb.setDirection(-1);
				}
			}
			if(bomb.getDirection() == 2){
				if(touchDecorB(bomb.getXPos(), bomb.getYPos()-15,this.bomb.get(i).getXPos(),this.bomb.get(i).getYPos()) != -1
						&& this.bomb.get(i).getYPos() != bomb.getYPos()){
					bomb.setYPos(this.bomb.get(i).getYPos()+40);
					bomb.setDirection(-1);
				}
			}
			if(bomb.getDirection() == 3){
				if(touchDecorB(bomb.getXPos(), bomb.getYPos()+15,this.bomb.get(i).getXPos(),this.bomb.get(i).getYPos()) != -1
						&& this.bomb.get(i).getYPos() != bomb.getYPos()){
					bomb.setYPos(this.bomb.get(i).getYPos()-40);
					bomb.setDirection(-1);
				}
			}
		}
		for(int i = 0; i < monster.size(); i++){
			if(touchDecorB(bomb.getXPos(), bomb.getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
				bomb.setDirection(-1);
			}
		}
		for(int i = 0; i < decor.size(); i++){
			if(bomb.getDirection() == 0){
				if(touchDecorB(bomb.getXPos()-15, bomb.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
						&& decor.get(i).getClass() != Floor.class){
					bomb.setXPos(decor.get(i).getXPos()+45);
					bomb.setDirection(-1);
				}
			}
			if(bomb.getDirection() == 1){
				if(touchDecorB(bomb.getXPos()+5, bomb.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
						&& decor.get(i).getClass() != Floor.class){
					bomb.setXPos(decor.get(i).getXPos()-35);
					bomb.setDirection(-1);
				}
			}
			if(bomb.getDirection() == 2){
				if(touchDecorB(bomb.getXPos(), bomb.getYPos()-15,decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
						&& decor.get(i).getClass() != Floor.class){
					bomb.setYPos(decor.get(i).getYPos()+45);
					bomb.setDirection(-1);
				}
			}
			if(bomb.getDirection() == 3){
				if(touchDecorB(bomb.getXPos(), bomb.getYPos()+5,decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
						&& decor.get(i).getClass() != Floor.class){
					bomb.setYPos(decor.get(i).getYPos()-35);
					bomb.setDirection(-1);
				}
			}
		}
		bomb.move();
	}
	
	public void deflagrationAppear(BombDeflagration bombDef, int rangeBomb){
		int liste[][] = bombDef.listeExplosion(rangeBomb);
		for(int j = 0; j < bombDef.getPortee();j++){
			for(int i = 0; i < decor.size(); i++){
				if(touchArrow(liste[0][j],bombDef.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
						&& decor.get(i).getClass() != Floor.class){
					if(decor.get(i).getClass() == Jar.class && bombDef.getL() == 1){
						bombDef.getLeft().add(liste[0][j]);
						bombDef.getLeft().add(liste[0][j+1]);
						//left.add(liste[0][j+2]);
						((Jar) decor.get(i)).randomBonus(bonus, decor.get(i).getXPos(), decor.get(i).getYPos());
						decor.remove(i);
						decor.get(i-1).setName("res/ForestBrokenJar");
						Sound soundJar = new Sound();
						soundJar.playSound("jarbroken");
					}
					bombDef.setL(0);
				}
				if(touchArrow(liste[1][j],bombDef.getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
						&& decor.get(i).getClass() != Floor.class){
					if(decor.get(i).getClass() == Jar.class && bombDef.getR() == 1){
						bombDef.getRight().add(liste[1][j]);
						bombDef.getRight().add(liste[1][j+1]);
						//right.add(liste[1][j+2]);
						((Jar) decor.get(i)).randomBonus(bonus, decor.get(i).getXPos(), decor.get(i).getYPos());
						decor.remove(i);
						decor.get(i-1).setName("res/ForestBrokenJar");
						Sound soundJar = new Sound();
						soundJar.playSound("jarbroken");
					}
					bombDef.setR(0);
				}
				if(touchArrow(bombDef.getXPos(),liste[2][j],decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
						&& decor.get(i).getClass() != Floor.class){
					if(decor.get(i).getClass() == Jar.class && bombDef.getU() == 1){
						bombDef.getDown().add(liste[2][j]);
						bombDef.getDown().add(liste[2][j+1]);
						//down.add(liste[2][j+2]);
						((Jar) decor.get(i)).randomBonus(bonus, decor.get(i).getXPos(), decor.get(i).getYPos());
						decor.remove(i);
						decor.get(i-1).setName("res/ForestBrokenJar");
						Sound soundJar = new Sound();
						soundJar.playSound("jarbroken");						
					}
					bombDef.setU(0);
					}
				if(touchArrow(bombDef.getXPos(),liste[3][j],decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
						&& decor.get(i).getClass() != Floor.class){
					//System.out.println("obstacle " + D);
					//System.out.println("avant " +D + " " + portee);
					if(decor.get(i).getClass() == Jar.class && bombDef.getD() == 1){
						bombDef.getUp().add(liste[3][j]);
						bombDef.getUp().add(liste[3][j+1]);
						//up.add(liste[3][j+2]);
						((Jar) decor.get(i)).randomBonus(bonus, decor.get(i).getXPos(), decor.get(i).getYPos());
						decor.remove(i);
						decor.get(i-1).setName("res/ForestBrokenJar");
						Sound soundJar = new Sound();
						soundJar.playSound("jarbroken");
					}
					bombDef.setD(0);
				}
			}
			if(bombDef.getL() == 1){
				bombDef.getLeft().add(liste[0][j]);
			}
			if(bombDef.getR() == 1){
				bombDef.getRight().add(liste[1][j]);
			}
			if(bombDef.getU() == 1){
				bombDef.getUp().add(liste[2][j]);
			}
			if(bombDef.getD() == 1){
				bombDef.getDown().add(liste[3][j]);
			}
		}	
	}
	
	public void defInteraction(BombDeflagration bombDef){
		for(int j = 0; j < bombDef.getUp().size(); j++){
			for(int i = 0; i< link.size(); i++){
				if(touchArrow(bombDef.getXPos(),bombDef.getUp().get(j),link.get(i).getXPos(),link.get(i).getYPos()) != -1){
					link.get(i).getDamage(2);
				}
			}
			for(int i = 0; i< monster.size(); i++){
				if(touchArrow(bombDef.getXPos(),bombDef.getUp().get(j),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
					monster.get(i).getDamage(2);
				}
			}
			for(int i = 0; i< bomb.size(); i++){
				if(touchArrow(bombDef.getXPos(),bombDef.getUp().get(j),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
					bomb.get(i).setTime(15);
				}
			}
		}
		
		for(int j = 0; j < bombDef.getDown().size(); j++){
			for(int i = 0; i< link.size(); i++){
				if(touchArrow(bombDef.getXPos(),bombDef.getDown().get(j),link.get(i).getXPos(),link.get(i).getYPos()) != -1){
					link.get(i).getDamage(2);
				}
			}
			for(int i = 0; i< monster.size(); i++){
				if(touchArrow(bombDef.getXPos(),bombDef.getDown().get(j),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
					monster.get(i).getDamage(2);
				}
			}
			for(int i = 0; i< bomb.size(); i++){
				if(touchArrow(bombDef.getXPos(),bombDef.getDown().get(j),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
					bomb.get(i).setTime(15);
				}
			}
		}

		for(int j = 0; j < bombDef.getLeft().size(); j++){
			for(int i = 0; i< link.size(); i++){
				if(touchArrow(bombDef.getLeft().get(j),bombDef.getYPos(),link.get(i).getXPos(),link.get(i).getYPos()) != -1){
					link.get(i).getDamage(2);
				}
			}
			for(int i = 0; i< monster.size(); i++){
				if(touchArrow(bombDef.getLeft().get(j),bombDef.getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
					monster.get(i).getDamage(2);
				}
			}
			for(int i = 0; i< bomb.size(); i++){
				if(touchArrow(bombDef.getLeft().get(j),bombDef.getYPos(),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
					bomb.get(i).setTime(15);
				}
			}
		}
		
		for(int j = 0; j < bombDef.getRight().size(); j++){
			for(int i = 0; i< link.size(); i++){
				if(touchArrow(bombDef.getRight().get(j),bombDef.getYPos(),link.get(i).getXPos(),link.get(i).getYPos()) != -1){
					link.get(i).getDamage(2);
				}
			}
			for(int i = 0; i< monster.size(); i++){
				if(touchArrow(bombDef.getRight().get(j),bombDef.getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
					monster.get(i).getDamage(2);
				}
			}
			for(int i = 0; i< bomb.size(); i++){
				if(touchArrow(bombDef.getRight().get(j),bombDef.getYPos(),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
					bomb.get(i).setTime(15);
				}
			}
		}
	}
}
