package tlob.model;

public class Monster extends Character {

	public Monster (int lifePoint, int xPos, int yPos, int speed,int direction,String name)
	{
		super (lifePoint, xPos, yPos, speed, direction, name);
	}
	
	public void moveUp ()
	{
		setYPos(yPos + getFrozen()*speed);
		direction = 1;
	}

	public void moveDown ()
	{
		setYPos(yPos - getFrozen()*speed);
		direction = 2;
	}

	public void moveRight ()
	{
		setXPos(xPos + getFrozen()*speed);
		direction = 3;
	}

	public void moveLeft ()
	{
		setXPos(xPos - getFrozen()*speed);
		direction = 4;
	}
	
}
