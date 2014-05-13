package tlob.model;

public class Item{
	private int xPos;
	private int yPos;
	private String name;
	private int myTick;
	private int actualFrame = 1;
	public Item(int xPos,int yPos,String name){
		this.xPos = xPos;
		this.yPos = yPos;
		this.name = name;
	}
	
	//view
	
	/*
	public void tick(ImageAnimeDirection image, int c) {
		this.mytick++;
		if(this.mytick == c) {
			this.actualFrame++;
			this.mytick = 0;
			if(this.actualFrame == IAD.getFrames()+1)
				this.actualFrame = 1;
		}
	}
	
	public int getC()
	{ 
		return c;
	}
	*/
	
	
	public int getMyTick(){
		return this.myTick;
	}

	public void setMyTick(int a)
	{
		this.myTick =a;
	}
	
	public int getActualFrame(){
		return this.actualFrame;
	}

	public void setActualFrame(int a)
	{
		this.actualFrame=a;
	}
	
	public int getXPos()
	{ 
		return xPos;
	}
	
	public void setXPos(int xPos)
	{
		this.xPos = xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public void setYPos(int yPos)
	{ 
		this.yPos = yPos;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name=name;
	}

}
