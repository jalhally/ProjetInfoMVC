package tlob.model;

import java.util.List;

public class Ranged extends Monster {
	
	
	public Ranged (int lifePoint, int xPos, int yPos, int speed,int direction, String name)
	{
		super(lifePoint, xPos, yPos,speed, direction,name);
	}
	
	
	public List<Arrow> fireArrow(List<Arrow> liste){
		
		//view
		//tick(getIAD(),5);
		
		//if(getActualFrame() == 6){
			liste.add(new Arrow(xPos, yPos, "res/Arrow", direction));
		//}
		return liste;
		 
	}
	
	/*
	public void IARanged(Link Link)
	{
		while (this.xPos != Link.getXPos() || this.yPos != Link.getYPos() )
		{
			if (this.xPos < Link.getXPos() )
			{
				moveRight();
				direction = 3;
			}
			
			else if (this.xPos > Link.getXPos())
			{
				moveLeft();
				direction =4;
			}
			
			else if (this.yPos < Link.getYPos())
			{
				moveUp();
				direction = 1;
			}
			
			else if (this.yPos > Link.getYPos())
			{
				moveDown();
				direction = 2;
			}
			else if (this.xPos == Link.getXPos() && this.yPos < Link.getYPos())  // attention aux decors
			{
				//fireArrow(1);
			}
			else if (this.xPos == Link.getXPos() && this.yPos > Link.getYPos())
			{
				//fireArrow(2);
			}
			else if (this.yPos == Link.getYPos() && this.xPos < Link.getXPos())
			{
				//fireArrow(3);
			}
			else if (this.yPos == Link.getYPos() && this.xPos < Link.getXPos())
			{
				//fireArrow(4);
			}
		}
		
	}
*/
}
