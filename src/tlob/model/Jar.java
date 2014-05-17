package tlob.model;

import java.util.List;


public class Jar extends Decor {
	
	private String imageBonus[] ={"res/Heart","res/BombPlus","res/BombRange","res/ArrowPlus","res/SpeedBonus",
			"res/Gauntlet2","res/Key","res/FireStaff","res/IceStaff","res/Rubis"};
	
	
	public Jar(int xPos, int yPos, String name) {
		super(xPos,yPos,name);
	}
	
	/*
	public Trapped trappedMonster(int lifePoint, int xPos, int yPos, int speed,int direction,ImageAnimeDirection image, boolean hidden) {
		Trapped trapped=new Trapped(lifePoint, xPos, yPos, speed, direction, image);
		return trapped;
		
	}
	*/
	
	public void randomBonus(List<Bonus> bonus, int x, int y) {
		int bonusType=-1;
		java.util.Random r=new java.util.Random( ) ; 
		int random = r.nextInt(100);
		int random2=r.nextInt(3);
		if(random%2==0) {
			bonusType=9;
		}
		if(random%5==0) {
			bonusType=0;
		}
		if(random%20==0) {
			if(random2==0) {bonusType=7;}
			else if(random2==1) {bonusType=8;}
			else{bonusType=3;}
		}
		if(bonusType>=0) {
		bonus.add(new Bonus(x,y,imageBonus[bonusType],bonusType));
		}
	}
	
	public void randomBonusVersus(List<Bonus> bonus, int x, int y) {
		int bonusType=-1;
		java.util.Random r=new java.util.Random( ) ; 
		int random = r.nextInt(100);
		int random2=r.nextInt(3);
		if(random%5==0) {
			bonusType=0;
		}
		if(random%10==0) {
			if(random2==0) {bonusType=7;}
			else if(random2==1) {bonusType=8;}
			else{bonusType=3;}
		}
		if(random%20 == 0) {
			if(random2 == 0) {bonusType=1;}
			else if(random2 == 1) {bonusType=2;}
			else {bonusType=4;}
		}
		if(bonusType>=0) {
		bonus.add(new Bonus(x,y,imageBonus[bonusType],bonusType));
		}
	}
	
} 
