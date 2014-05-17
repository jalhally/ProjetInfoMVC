package tlob.model;

import java.util.List;

public class SpawnerMonster extends Decor {
	
public SpawnerMonster(int xPos, int yPos, String name) {
		super(xPos,yPos,name);
	}
	
public void spawnMonster(List<Monster> monster){
	java.util.Random r=new java.util.Random( ) ; 
	int random = r.nextInt(4);	
	switch(random){
	case 0:
		monster.add(new Melee(2,this.xPos,this.yPos,1,3,"res/MeleeRun"));
		break;
	case 1:
		monster.add(new Ranged(1,this.xPos,this.yPos,1,3,"res/RangedRun"));
		break;
	//case 2:
		//monster.add(new Underground(2,this.xPos,this.yPos,1,3,"res/melee"));
		//break;
	case 3:
		monster.add(new Bomber(1,this.xPos,this.yPos,1,3,"res/BomberRun"));
		break;
	}
}


}


