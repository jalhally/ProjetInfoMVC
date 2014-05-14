package tlob.main;

import java.util.ArrayList;
import java.util.List;

import tlob.controller.*;
import tlob.model.*;
import tlob.view.*;

public class main {

	public static void main(String[] args) {
		/*Map map = new Map(16,16,"1","3","1");
		Level level = new Level(map);
		GameController controller = new GameController(level);
		LoadIAD load = new LoadIAD();	
		Fenetre fenetre = new Fenetre(level,controller,load);
		*/
		List<Menu> menu = new ArrayList<Menu>();
		Menu homescreen = new Menu(0,0,"res/Jar", 0);
		Menu solo = new Menu(15*20,15*10,"res/Bomb",2);
		Menu option = new Menu(15*20,15*20,"res/Rock", 1);
		menu.add(homescreen);
		menu.add(solo);
		menu.add(option);
		Level level = new Level(menu);
		LoadIAD load = new LoadIAD();
		Map map = new Map(16,16,"1","3","1");
		level.createLevel(map);
		GameController controller = new GameController(level);
		new Fenetre(level,controller,load);
		

	}	
	

}
