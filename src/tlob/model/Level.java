package tlob.model;

import java.util.ArrayList;
import java.util.List;

public class Level{
	
	private Map map;
	private List<Link> link;
	private List<Decor> decor;
	private List<Monster> monster;
	private List<Bomb> bomb;
	private List<BombDeflagration> bombDeflagration;
	private List<Arrow> arrow;
	private List<Bonus> bonus;
	private List<Menu> menu;
	private int status = 0;
	
	public Level(List<Menu> menu){
		this.menu = menu;
		
	}
	
	public void createLevel(Map map){
		this.map = map;
		char[][] tableau = new char[16][16];
		tableau = map.loadRoom();
		decor = map.mapToListDecor(tableau);
		monster = map.mapToListMonster(tableau);
		link = new ArrayList<Link>();
		link.add(new Link(3,200,200,2,1,"res/LinkRun"));
		
		link.get(0).setGauntlet(true);
		link.get(0).setNumberBomb(5);
		link.get(0).setRangeBomb(4);
		
		bomb = new ArrayList<Bomb>();
		arrow = new ArrayList<Arrow>();
		bonus = new ArrayList<Bonus>();
		bombDeflagration = new ArrayList<BombDeflagration>();
	}

	public Map getMap(){
		return this.map;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
	public int getStatus(){
		return this.status;
	}
	
	public List<Link> getLink(){
		return this.link;
	}

	public List<Decor> getDecor(){
		return this.decor;
	}

	public List<Monster> getMonster(){
		return this.monster;
	}

	public List<Bomb> getBomb(){
		return this.bomb;
	}

	public List<BombDeflagration> getBombDeflagration(){
		return this.bombDeflagration;
	}

	public List<Arrow> getArrow(){
		return this.arrow;
	}
	
	public List<Bonus> getBonus(){
		return this.bonus;
	}

	public List<Menu> getMenu() {
		return this.menu;
	}

}