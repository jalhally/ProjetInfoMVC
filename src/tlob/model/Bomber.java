package tlob.model;

import java.util.List;

public class Bomber extends Monster {
	
	
	public Bomber (int lifePoint, int xPos, int yPos, int speed,int direction, String name)
	{
		super(lifePoint, xPos, yPos,speed, direction, name);
	}
	
	//THROW c'est le setBomb de Link
	public List<Bomb> setBomb(List<Bomb> liste, String name)
	{
		int x,y;
		int k = 1;
		if(xPos%40 <= 20){
			x = xPos - xPos%40;
		}
		else{
			x = xPos + 40 - xPos%40;
		}
		if(yPos%40 <= 20){
			y = yPos - yPos%40;
		}
		else{
			y = yPos + 40 - yPos%40;
		}
		for(int i = 0; i < liste.size(); i++){
			if(x + 5 == liste.get(i).getXPos() && y + 5 == liste.get(i).getYPos()){
				k = 0;
			}
		}
		if (k == 1 && getInvincible() == 1){
			liste.add( new Bomb(x+5, y+5, name, -1)) ;
		}
		return liste;
	}
	

}
