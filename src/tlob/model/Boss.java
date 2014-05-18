package tlob.model;

import java.util.List;

public class Boss extends Monster{	
	
	private boolean rage = false;

	public Boss (int lifePoint, int xPos, int yPos, int speed,int direction,String name)
	{
		super(lifePoint, xPos, yPos,speed, direction, name);
	}
	
	public boolean getRage()
	{
		return rage;
	}
	
	public void setRage(boolean rage)
	{
		this.rage = rage;
	}
	
	public void rage() // remplace le skinChange
	{
		setRage(true);
	}
	
	
	public List<FireBall> fireBall(List<FireBall> fireBall, Link link) // pas sur
	{
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", link.getXPos()+10, link.getYPos()+10,15*40,15*40));
		return fireBall;
	}
	
	public List<FireBall> fireBall2(List<FireBall> fireBall) // pas sur
	{
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", getXPos()+16, getYPos()+10,15*40,15*40));
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", getXPos()+4, getYPos()+10,15*40,15*40));
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", getXPos()+10, getYPos()+16,15*40,15*40));
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", getXPos()+10, getYPos()+4,15*40,15*40));
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", getXPos()+16, getYPos()+16,15*40,15*40));
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", getXPos()+16, getYPos()+4,15*40,15*40));
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", getXPos()+4, getYPos()+16,15*40,15*40));
		fireBall.add(new FireBall(getXPos()+10, getYPos()+10, "res/fire", getXPos()+4, getYPos()+4,15*40,15*40));
		return fireBall;
	}
	
	public List<Thunder> thunder(List<Thunder> thunder, Link link) // pas sur
	{
		thunder.add(new Thunder(link.getXPos(), link.getYPos(), "res/Thunder"));
		return thunder;
	}
	
	
	/*

	public Fireball2 fireBall2()
	{
		FireBall2 fireBall2 = new FireBall2(this.xPos, this.yPos);
		return fireBall2;
	}
	
	public Thunder thunderBolt(Link Link)
	{
		 return Thunder thunder = new Thunder (Link.getXPos(), Link.getYPos());
	}
	
	public void teleportation(Map map) // dunno
	{
		Random r1 = new Random();
		Random r2 = new Random();
		this.xPos = r1.nextInt(map.getXLimit);
		this.yPos =r2.nextInt(map.getYlimit);
	}
	*/
	// IA
}


