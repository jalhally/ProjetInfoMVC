package tlob.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.ArrayList;

import tlob.model.*;
import tlob.model.Character;

public class ImageAnimeDirection {
	private List<Image> liste;
	public final static int GAUCHE = 0;
	public final static int DROITE = 1;
	public final static int HAUT = 2;
	public final static int BAS = 3;
	String nomBase;
	private int frames;
	private Image image;
	
	public ImageAnimeDirection(String name){
		this.nomBase = name;
		this.image = Toolkit.getDefaultToolkit().getImage(nomBase + ".png");
	}
	
	public ImageAnimeDirection(String nomBase, int frames) {
		this.frames = frames;
		this.nomBase = nomBase;
		liste = new ArrayList<Image>();
		for(String dir : new String[]{"Left", "Right", "Up", "Down"}){
			for(int i = 1; i<= frames; i++){
				liste.add(Toolkit.getDefaultToolkit().getImage(nomBase + dir + Integer.toString(i) + ".png"));
			}
		}
	}
	
	public String getName(){
		return this.nomBase;
	}
	
	public int getFrames(){
		return this.frames;
	}
	
	public Image getImage(){
		return this.image;
	}
	
	public Image getImageAnime(Character character){
		if(character.getDirection() == GAUCHE){
			return liste.get(character.getActualFrame() -1);
		}
		else if(character.getDirection() == DROITE){
			return liste.get(character.getActualFrame() + frames-1);
		}
		else if(character.getDirection() == HAUT){
			return liste.get(character.getActualFrame() + 2*frames-1);
		}
		else{
			return liste.get(character.getActualFrame() + 3*frames-1);
		}
	}
	
	public Image getImage(FireBall1 f){
		return liste.get(0);
	}
	
	public Image getImageAnime(Arrow arrow){
		if(arrow.getDirection() == GAUCHE){
			return liste.get(arrow.getActualFrame() -1);
		}
		else if(arrow.getDirection() == DROITE){
			return liste.get(arrow.getActualFrame()  + frames-1);
		}
		else if(arrow.getDirection() == HAUT){
			return liste.get(arrow.getActualFrame()  + 2*frames-1);
		}
		else{
			return liste.get(arrow.getActualFrame()  + 3*frames-1);
		}
	}
	
	public List<Image> getImageDirection(int direction){
		ArrayList<Image> l = new ArrayList<Image>();
		if(direction == GAUCHE){
			for(int i=0; i< frames;i++){
				l.add(liste.get(i));
			}
		}
		else if(direction == DROITE){
			for(int i=0; i< frames;i++){
				l.add(liste.get(i + frames));
			}
		}
		else if(direction == HAUT){
			for(int i=0; i< frames;i++){
				l.add(liste.get(i + 2*frames));
			}
		}
		else{
			for(int i=0; i< frames;i++){
				l.add(liste.get(i + 3*frames));
			}
		}
		return l;
	}
	
}
	