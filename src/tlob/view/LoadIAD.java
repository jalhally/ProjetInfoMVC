package tlob.view;

import java.util.ArrayList;
import java.util.List;

public class LoadIAD {
	
	private List<ImageAnimeDirection> dataIAD;
	
	public LoadIAD(){ //ne pas oublier de load
		List<ImageAnimeDirection> dataIAD = new ArrayList<ImageAnimeDirection>();
		this.dataIAD = dataIAD;
		dataIAD.add(new ImageAnimeDirection("res/2"));
		dataIAD.add(new ImageAnimeDirection("res/store"));
		dataIAD.add(new ImageAnimeDirection("res/store1"));
		dataIAD.add(new ImageAnimeDirection("res/store2"));		
		dataIAD.add(new ImageAnimeDirection("res/store3"));	
		dataIAD.add(new ImageAnimeDirection("res/store4"));
		dataIAD.add(new ImageAnimeDirection("res/store5"));
		dataIAD.add(new ImageAnimeDirection("res/store1choose"));
		dataIAD.add(new ImageAnimeDirection("res/store2choose"));		
		dataIAD.add(new ImageAnimeDirection("res/store3choose"));	
		dataIAD.add(new ImageAnimeDirection("res/store4choose"));
		dataIAD.add(new ImageAnimeDirection("res/store5choose"));
		dataIAD.add(new ImageAnimeDirection("res/gameOver"));
		dataIAD.add(new ImageAnimeDirection("res/yesbombs"));
		dataIAD.add(new ImageAnimeDirection("res/yes"));
		dataIAD.add(new ImageAnimeDirection("res/nobombs"));
		dataIAD.add(new ImageAnimeDirection("res/no"));
		dataIAD.add(new ImageAnimeDirection("res/menu"));
		dataIAD.add(new ImageAnimeDirection("res/1player"));
		dataIAD.add(new ImageAnimeDirection("res/1playerbombs"));
		dataIAD.add(new ImageAnimeDirection("res/2players"));
		dataIAD.add(new ImageAnimeDirection("res/2playersbombs"));
		dataIAD.add(new ImageAnimeDirection("res/LinkRun",6));
		dataIAD.add(new ImageAnimeDirection("res/LinkArrow",6));
		dataIAD.add(new ImageAnimeDirection("res/Arrow",3));
		dataIAD.add(new ImageAnimeDirection("res/Deflagration",2));
		dataIAD.add(new ImageAnimeDirection("res/MeleeRun",4));
		dataIAD.add(new ImageAnimeDirection("res/RangedRun",5));
		dataIAD.add(new ImageAnimeDirection("res/RangedArrow",1));
		dataIAD.add(new ImageAnimeDirection("res/BackgroundForest"));
		dataIAD.add(new ImageAnimeDirection("res/LittleTree"));
		dataIAD.add(new ImageAnimeDirection("res/LittleTreeObstacle"));
		dataIAD.add(new ImageAnimeDirection("res/Jar"));
		dataIAD.add(new ImageAnimeDirection("res/Rocks"));
		dataIAD.add(new ImageAnimeDirection("res/Rock"));
		dataIAD.add(new ImageAnimeDirection("res/Root"));
		dataIAD.add(new ImageAnimeDirection("res/Bomb"));
		dataIAD.add(new ImageAnimeDirection("res/ForestBrokenJar"));
		dataIAD.add(new ImageAnimeDirection("res/Heart"));
		dataIAD.add(new ImageAnimeDirection("res/BombPlus"));
		dataIAD.add(new ImageAnimeDirection("res/BombRange"));
		dataIAD.add(new ImageAnimeDirection("res/Rubis"));
		dataIAD.add(new ImageAnimeDirection("res/FireStaff"));
		dataIAD.add(new ImageAnimeDirection("res/IceStaff"));
		dataIAD.add(new ImageAnimeDirection("res/Gauntlet2"));
		dataIAD.add(new ImageAnimeDirection("res/Key"));
		dataIAD.add(new ImageAnimeDirection("res/SpeedBonus"));
		dataIAD.add(new ImageAnimeDirection("res/ArrowPlus"));
		dataIAD.add(new ImageAnimeDirection("res/TreasureChest1"));
		dataIAD.add(new ImageAnimeDirection("res/TreasureChest2"));
	}
	
	public ImageAnimeDirection stringToIAD(String name){
		for(int i = 0; i < dataIAD.size(); i++){
			if(dataIAD.get(i).getName() == name){
				return dataIAD.get(i);
			}
		}
		return dataIAD.get(0);
		//load Kirby si ne trouve pas le nom
	}
	
}
