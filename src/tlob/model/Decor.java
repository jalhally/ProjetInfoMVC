package tlob.model;

public class Decor{
	
	protected int xPos;
	protected int yPos;
	protected String name;
	private int cooldown = 0;
	private int tick = 0;
	

	public Decor(int xPos, int yPos, String name) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.name = name;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;		
	}
	
	public void setXPos(int xPos) {
		this.xPos=xPos;
	}
	
	public void setYPos(int yPos) {
		this.yPos=yPos;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setCooldown(int i) {
		this.cooldown = i;
		
	}

	public int getCooldown() {
		return this.cooldown;
	}
	
	public void cdTick(int constante) {
		tick++;
		if(tick == constante) {
			cooldown++;
			tick = 0;
		}
	}
}
