package tlob.model;

public class Trap extends Decor {
	
	protected int damage = 1;
	
	public Trap(int xPos, int yPos, String name) {
		super(xPos,yPos,name);
	}
	
	public int getDamage() {
		return this.damage;		
	}
	

}
