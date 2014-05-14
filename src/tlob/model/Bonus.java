package tlob.model;

public class Bonus extends Decor {
	private int number;
	private int maxSpeed;
	
	
	public Bonus(int xPos, int yPos,String name,int number){
		super(xPos,yPos,name);
		this.number = number;
	}

public void activation(Link l){
	switch (this.number){
	case 0: //Heart
		if(l.getLifePoint()<3) {
		l.setLifePoint(l.getLifePoint()+1); 
		break;
		}
	case 1: //BombPlus
		l.setNumberBomb(l.getNumberBomb()+1); 
		break;
	case 2: //RangeBomb
		l.setRangeBomb(l.getRangeBomb()+1); 

		break;
	case 3: //ArrowPlus
		if(l.getNumberArrow()<99) {
		l.setNumberArrow(l.getNumberArrow()+1);
		break;
		}
	case 4: //Speed
		if(l.getSpeed()<maxSpeed) {
		l.setSpeed(l.getSpeed()+1);
		break;
		}
	case 5: //Gauntlet
		l.setGauntlet(true);
		break;
	case 6: //Key
		l.setKey(true);
		break;
	case 7: //FireStaff
		l.setStaff(0);
		break;
	case 8: //IceStaff
		l.setStaff(1);
		break;
	case 9: //Rupee
		l.setNumberCoin(l.getNumberCoin()+1);
		break;
		
	}
		
	}
}

