package tlob.main;

import tlob.controller.*;
import tlob.model.*;
import tlob.view.*;

public class main {

	public static void main(String[] args) {
		Map map = new Map(16,16,"1","3","1");
		Level level = new Level(map);
		GameController controller = new GameController(level);
		LoadIAD load = new LoadIAD();
		Fenetre fenetre = new Fenetre(level,controller,load);
	}

}
