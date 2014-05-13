package tlob.model;

public class MovingTrap extends Trap {
	
	public MovingTrap(int xPos, int yPos, String name) {
		super(xPos,yPos,name);
	}
	
	public void moveUp ()
	{
		setYPos(yPos + 1);
	}

	public void moveDown ()
	{
		setYPos(yPos - 1);
	}

	public void moveRight ()
	{
		setXPos(xPos + 1);
	}

	public void moveLeft ()
	{
		setXPos(xPos - 1);
	}


}
