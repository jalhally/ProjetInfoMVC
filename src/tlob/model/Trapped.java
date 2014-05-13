package tlob.model;

public class Trapped extends Monster {
	

	//private boolean hidden; //j ai rajoute ca (a voir si c est juste)
	
	public Trapped (int lifePoint, int xPos, int yPos, int speed,int direction, String name)
	{
		super(lifePoint, xPos, yPos,speed, direction, name);
	//	this.hidden = hidden;
	}
	
	
	/*public boolean getHidden()
	{
		return hidden;
	}
	
	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
	}
	
	public void appear()
	{
		this.hidden = false;
	}**/

}
