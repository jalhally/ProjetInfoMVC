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
		Menu homescreen = new Menu(0,0,"res/menu", 0);
		Menu solo = new Menu(17*10,13*40,"res/1playerbombs",2);
		Menu option = new Menu(7*20,15*40,"res/2players", 1);
		menu.add(homescreen);
		menu.add(solo);
		menu.add(option);
		List<Menu> gameOver = new ArrayList<Menu>();
		Menu gameOverScreen = new Menu(0,100,"res/gameOver", 0);
		Menu yes = new Menu(13*20,12*40,"res/yesbombs",2);
		Menu no = new Menu(22*20,12*40,"res/no", 1);
		gameOver.add(gameOverScreen);
		gameOver.add(yes);
		gameOver.add(no);
		
		Level level = new Level(menu,gameOver);
		LoadIAD load = new LoadIAD();
		GameController controller = new GameController(level);
		new Fenetre(level,controller,load);
		

	}	
	

}
