package tlob.model;

public class Monster extends Character {

	public Monster (int lifePoint, int xPos, int yPos, int speed,int direction,String name)
	{
		super (lifePoint, xPos, yPos, speed, direction, name);
	}
	
	public void move()

	{
		if(direction == 0){
			setXPos(getXPos() - getFrozen()*getL()*speed);
			//tick(3,5);
		}
		if(direction == 1){
			setXPos(getXPos() + getFrozen()*getR()*speed);
			//tick(3,5);
		}
		if(direction == 2){
			setYPos(getYPos() - getFrozen()*getU()*speed);
			//tick(3,5);
		}
		if(direction == 3){
			setYPos(getYPos() + getFrozen()*getD()*speed);
			//tick(3,5);
		}
	}
	
}
