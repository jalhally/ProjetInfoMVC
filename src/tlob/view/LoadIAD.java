package tlob.view;

import java.util.ArrayList;
import java.util.List;

public class LoadIAD {
	
	private List<ImageAnimeDirection> dataIAD;
	
	public LoadIAD(){ //ne pas oublier de load
		List<ImageAnimeDirection> dataIAD = new ArrayList<ImageAnimeDirection>();
		this.dataIAD = dataIAD;
		dataIAD.add(new ImageAnimeDirection("res/2"));
		dataIAD.add(new ImageAnimeDirection("res/LinkRun",6,5));
		dataIAD.add(new ImageAnimeDirection("res/LinkArrow",6,5));
		dataIAD.add(new ImageAnimeDirection("res/Arrow",3,5));
		dataIAD.add(new ImageAnimeDirection("res/Deflagration",2,2));
		dataIAD.add(new ImageAnimeDirection("res/MeleeRun",1,5));
		dataIAD.add(new ImageAnimeDirection("res/BackgroundForest"));
		dataIAD.add(new ImageAnimeDirection("res/LittleTree"));
		dataIAD.add(new ImageAnimeDirection("res/Jar"));
		dataIAD.add(new ImageAnimeDirection("res/Rocks"));
		dataIAD.add(new ImageAnimeDirection("res/Rock"));
		dataIAD.add(new ImageAnimeDirection("res/Root"));
		dataIAD.add(new ImageAnimeDirection("res/Bomb"));
		dataIAD.add(new ImageAnimeDirection("res/ForestBrokenJar"));
		//dataIAD.add(new ImageAnimeDirection(""));
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
