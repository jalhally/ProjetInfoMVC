package tlob.model;

import java.util.List;

public class Link extends Character {
	

private int numberBomb = 1;
private int rangeBomb = 2;
private int numberArrow = 0;
private boolean gauntlet = false;
private boolean key = false;
private int staff=-1; //0=fire //1=ice
private int numberCoin = 0;
private int U = 1;
private int D = 1;
private int L = 1;
private int R = 1;

public Link (int lifePoint, int xPos, int yPos, int speed,int direction, String image)
{
	super(lifePoint, xPos, yPos, speed, direction, image);
}

public int getStaff() {
	
	return staff;
}

public void setStaff(int staff) {
	
	this.staff=staff;
}

public int getNumberBomb()
{
	return numberBomb;
}

public void setNumberBomb(int numberBomb)
{ 
	this.numberBomb = numberBomb;
}

public int getRangeBomb()
{
	return rangeBomb;
}

public void setRangeBomb(int rangeBomb)
{
	this.rangeBomb = rangeBomb;
}

public int getNumberArrow()
{
	return numberArrow;
}

public void setNumberArrow(int numberArrow)
{
	this.numberArrow = numberArrow;
}

public boolean getGauntlet()
{
	return gauntlet;
}

public void setGauntlet(boolean gauntlet)
{
	this.gauntlet = gauntlet;
}

public boolean getKey()
{
	return key;
}

public void setKey(boolean key)
{
	this.key = key;
	
}

public int getNumberCoin() {
	return numberCoin;
}

public void setNumberCoin(int numberCoin) {
	this.numberCoin=numberCoin;
}

public int getU(){
	return this.U;
}

public void setU(int U){
	this.U = U;
}

public int getD(){
	return this.D;
}

public void setD(int D){
	this.D = D;
}

public int getL(){
	return this.L;
}

public void setL(int L){
	this.L = L;
}

public int getR(){
	return this.R;
}

public void setR(int R){
	this.R = R;
}

public void moveUp ()

{
	direction = 2;
	setYPos(yPos - getFrozen()*U*speed);
	tick(6,5);
}

public void moveDown ()
{
	direction = 3;
	setYPos(yPos + getFrozen()*D*speed);
	tick(6,5);
}

public void moveRight ()
{
	direction = 1;
	setXPos(xPos + getFrozen()*R*speed);
	tick(6,5);
}

public void moveLeft ()
{
	direction = 0;
	setXPos(xPos - getFrozen()*L*speed);
	tick(6,5);
}

public List<Bomb> setBomb(List<Bomb> liste)
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
		liste.add( new Bomb(x+5, y+5, "res/Bomb")) ;
	}
	return liste;
}

public List<Arrow> fireArrow(List<Arrow> liste){
	
	tick(6,5);
	
	if(getActualFrame() == 6){
		liste.add(new Arrow(xPos, yPos, "res/Arrow", direction));
	}
	return liste;
	 
	}
	
}
