package tlob.model;


public class Treasure extends Decor {
	
	private int bonusType;
	

public Treasure(int xPos, int yPos, String name,int bonusType) {
	super(xPos,yPos,name);
	this.bonusType=bonusType;
	}


public int getBonusType() {
	
	return bonusType;
}

public void setBonusType(int bonusType) {
	
	this.bonusType=bonusType;
}

}